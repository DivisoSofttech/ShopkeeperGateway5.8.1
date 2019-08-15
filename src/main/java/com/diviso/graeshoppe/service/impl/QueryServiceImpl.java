package com.diviso.graeshoppe.service.impl;

import static org.elasticsearch.action.search.SearchType.QUERY_THEN_FETCH;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.diviso.graeshoppe.client.customer.domain.Customer;
import com.diviso.graeshoppe.client.order.model.Order;
import com.diviso.graeshoppe.client.order.model.OrderLine;
import com.diviso.graeshoppe.client.product.model.AuxilaryLineItem;
import com.diviso.graeshoppe.client.product.model.Category;
import com.diviso.graeshoppe.client.product.model.ComboLineItem;
import com.diviso.graeshoppe.client.product.model.EntryLineItem;
import com.diviso.graeshoppe.client.product.model.Product;
import com.diviso.graeshoppe.client.product.model.StockCurrent;
import com.diviso.graeshoppe.client.product.model.StockEntry;
import com.diviso.graeshoppe.client.product.model.UOM;
import com.diviso.graeshoppe.client.sale.domain.Sale;
import com.diviso.graeshoppe.client.sale.domain.TicketLine;
import com.diviso.graeshoppe.client.store.domain.Banner;
import com.diviso.graeshoppe.client.store.domain.DeliveryInfo;
import com.diviso.graeshoppe.client.store.domain.Review;
import com.diviso.graeshoppe.client.store.domain.Store;
import com.diviso.graeshoppe.client.store.domain.StoreType;
import com.diviso.graeshoppe.client.store.domain.Type;
import com.diviso.graeshoppe.client.store.domain.UserRating;
import com.diviso.graeshoppe.domain.Result;
/*import com.diviso.graeshoppe.client.product.domain.Product;
import com.diviso.graeshoppe.domain.Result;*/
import com.diviso.graeshoppe.service.QueryService;
import com.diviso.graeshoppe.web.rest.errors.BadRequestAlertException;
import com.github.vanroy.springdata.jest.JestElasticsearchTemplate;
import com.github.vanroy.springdata.jest.aggregation.AggregatedPage;
import com.github.vanroy.springdata.jest.mapper.JestResultsExtractor;
import com.google.gson.JsonObject;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.TermsAggregation;

@Service
public class QueryServiceImpl implements QueryService {
	private final JestClient jestClient;
	private final JestElasticsearchTemplate elasticsearchTemplate;

	public QueryServiceImpl(JestClient jestClient) {
		this.jestClient = jestClient;
		this.elasticsearchTemplate = new JestElasticsearchTemplate(this.jestClient);
	}

	@Autowired
	ElasticsearchOperations elasticsearchOperations;

	@Override
	public Page<Category> findAllCategories(String iDPcode, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("iDPcode", iDPcode))).build();
		return elasticsearchOperations.queryForPage(searchQuery, Category.class);
	}

	@Override
	public Page<Product> findAllProduct(String iDPcode, Pageable pageable) {
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", iDPcode)).build();
		return elasticsearchOperations.queryForPage(searchQuery, Product.class);
	}

	@Override
	public Page<Product> findAllProductBySearchTerm(String searchTerm, String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", searchTerm).prefixLength(3))
						.must(QueryBuilders.matchQuery("iDPcode", storeId)))
				.build();

		return elasticsearchOperations.queryForPage(searchQuery, Product.class);

	}

	@Override
	public Page<Product> findProductByCategoryId(Long categoryId, String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("category.id", categoryId))
						.must(QueryBuilders.matchQuery("iDPcode", storeId)))
				.build();
		return elasticsearchOperations.queryForPage(searchQuery, Product.class);
	}

	@Override
	public Page<StockCurrent> findStockCurrentByProductName(String name, String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("product.name", name))
						.must(QueryBuilders.matchQuery("product.iDPcode", storeId)))
				.build();
		return elasticsearchOperations.queryForPage(searchQuery, StockCurrent.class);
	}

	@Override
	public StockEntry findStockEntryByProductId(Long productId, String storeId) {
		StringQuery stringQuery = new StringQuery(
				QueryBuilders.boolQuery().must(QueryBuilders.termQuery("product.id", productId))
						.must(QueryBuilders.termQuery("product.userId", storeId)).toString());
		return elasticsearchOperations.queryForObject(stringQuery, StockEntry.class);
	}

	@Override
	public Page<EntryLineItem> findAllEntryLineItems(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("product.iDPcode", storeId))
				.build();
		return elasticsearchOperations.queryForPage(searchQuery, EntryLineItem.class);
	}

	public List<Result> findAll(String searchTerm, Pageable pageable) {
		List<Result> values = new ArrayList<Result>();

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(matchQuery("name", searchTerm).fuzziness(Fuzziness.TWO)).build();

		elasticsearchTemplate.query(searchQuery, new JestResultsExtractor<List<Result>>() {
			@Override
			public List<Result> extract(SearchResult response) {

				for (SearchResult.Hit<JsonObject, Void> searchHit : response.getHits(JsonObject.class)) {
					Result result = new Result();
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
							+ searchHit.source.get(JestResult.ES_METADATA_ID).getAsString());
					// result.setName(searchHit.source.get("name").getAsString());

					values.add(result);

				}
				return values;
			}
		});
		return values;

	}

	@Override
	public Page<Customer> findAllCustomers(String searchTerm, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(matchQuery("name", searchTerm).prefixLength(3)).build();

		return elasticsearchOperations.queryForPage(searchQuery, Customer.class);

	}

	@Override
	public List<String> findAllUom(Pageable pageable) {
		List<String> uomList = new ArrayList<String>();
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
				.withSearchType(QUERY_THEN_FETCH).withIndices("uom").withTypes("uom")
				.addAggregation(AggregationBuilders.terms("distinct_uom").field("name.keyword")).build();

		AggregatedPage<UOM> result = elasticsearchTemplate.queryForPage(searchQuery, UOM.class);
		TermsAggregation uomAgg = result.getAggregation("distinct_uom", TermsAggregation.class);

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<" + uomAgg.getBuckets().size());

		for (int i = 0; i < uomAgg.getBuckets().size(); i++) {
			uomList.add(uomAgg.getBuckets().get(i).getKey());
		}

		return uomList;
	}

	@Override
	public Page<Customer> findAllCustomersWithoutSearch(Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
		return elasticsearchOperations.queryForPage(searchQuery, Customer.class);
	}

	@Override
	public Page<Sale> findSales(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("userId", storeId))
				.withSort(SortBuilders.fieldSort("date").order(SortOrder.DESC)).withPageable(pageable).build();
		return elasticsearchOperations.queryForPage(searchQuery, Sale.class);

	}

	@Override
	public List<TicketLine> findTicketLinesBySaleId(Long saleId) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("sale.id", saleId)).build();
		return elasticsearchOperations.queryForPage(searchQuery, TicketLine.class).getContent();
	}

	@Override
	public Page<StockCurrent> findAllStockCurrents(String storeId, Pageable pageable) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", storeId)).build();

		return elasticsearchOperations.queryForPage(searchQuery, StockCurrent.class);
	}

	@Override
	public Page<StockEntry> findAllStockEntries(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("product.iDPcode", storeId))
				.build();
		return elasticsearchOperations.queryForPage(searchQuery, StockEntry.class);
	}

	@Override
	public Page<Product> findAllProducts(String storeId, Pageable pageable) {
		
		if(findProducts(pageable)==null){
			throw new BadRequestAlertException("NO products exist", "Product", "no products");
		}
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", storeId))
				.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC)).withPageable(pageable).build();
		
		return elasticsearchOperations.queryForPage(searchQuery, Product.class);
	}

	
	@Override
	public Page<Review> findAllReviews(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", storeId)).build();
		return elasticsearchOperations.queryForPage(searchQuery, Review.class);
	}

	@Override
	public Page<UserRating> findAllUserRatings(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", storeId)).build();
		return elasticsearchOperations.queryForPage(searchQuery, UserRating.class);
	}

	@Override
	public Store findStoreByRegNo(String regNo) {
		StringQuery stringQuery = new StringQuery(termQuery("regNo", regNo).toString());

		return elasticsearchOperations.queryForObject(stringQuery, Store.class);
	}

	@Override
	public Page<StockCurrent> findAllStockCurrentByCategoryId(Long categoryId, String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("product.category.id", categoryId))
						.must(QueryBuilders.matchQuery("iDPcode", storeId)))
				.build();
		return elasticsearchOperations.queryForPage(searchQuery, StockCurrent.class);
	}

	@Override
	public StockCurrent findStockCurrentByProductId(Long productId, String storeId) {
		StringQuery stringQuery = new StringQuery(
				QueryBuilders.boolQuery().must(QueryBuilders.termQuery("product.id", productId))
						.must(QueryBuilders.termQuery("product.iDPcode", storeId)).toString());
		return elasticsearchOperations.queryForObject(stringQuery, StockCurrent.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findDeliveryInfoByStoreId(java
	 * .lang.Long)
	 */
	@Override
	public Page<DeliveryInfo> findDeliveryInfoByStoreId(Long id) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.id", id)).build();
		return elasticsearchOperations.queryForPage(searchQuery, DeliveryInfo.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findOrderLinesByStoreId(java.
	 * lang.String)
	 */
	@Override
	public Page<Order> findOrderByStoreId(String storeId, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("storeId", storeId))
				.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC)).build();

		Page<Order> orderPage = elasticsearchOperations.queryForPage(searchQuery, Order.class);

		orderPage.forEach(order -> {

			order.setOrderLines(new HashSet<OrderLine>(findOrderLinesByOrderId(order.getId())));

		});

		return orderPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findOrderByStoreId(java.lang.
	 * String)
	 */
	@Override
	public List<OrderLine> findOrderLinesByOrderId(Long orderId) {
		StringQuery searchQuery = new StringQuery(termQuery("order.id", orderId).toString());
		return elasticsearchOperations.queryForList(searchQuery, OrderLine.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diviso.graeshoppe.service.QueryService#findAllCategories(org.
	 * springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Category> findAllCategories(Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
		return elasticsearchOperations.queryForPage(searchQuery, Category.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findAuxilaryLineItemsByStoreId
	 * (java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<AuxilaryLineItem> findAuxilaryLineItemsByIDPcode(String iDPcode, Pageable pageable) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("product.iDPcode", iDPcode))
				.build();

		return elasticsearchOperations.queryForPage(searchQuery, AuxilaryLineItem.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findUOMByStoreId(java.lang.
	 * String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<UOM> findUOMByIDPcode(String iDPcode, Pageable pageable) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", iDPcode)).build();

		return elasticsearchOperations.queryForPage(searchQuery, UOM.class);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findAllStoreTypesByStoreId(
	 * java.lang.String)
	 */
	@Override
	public List<StoreType> findAllStoreTypesByStoreId(String regNo) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", regNo)).build();

		return elasticsearchOperations.queryForList(searchQuery, StoreType.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.diviso.graeshoppe.service.QueryService#findAllBannersByStoreId(java.
	 * lang.String)
	 */
	@Override
	public List<Banner> findAllBannersByStoreId(String regNo) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", regNo)).build();

		return elasticsearchOperations.queryForList(searchQuery, Banner.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diviso.graeshoppe.service.QueryService#
	 * findNotAuxNotComboProductsByIDPcode(java.lang.String,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Product> findNotAuxNotComboProductsByIDPcode(String iDPcode, Pageable pageable) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", iDPcode)).build();

		List<Product> products = elasticsearchOperations.queryForList(searchQuery, Product.class);

		List<Product> notAuxNotComboProducts = new ArrayList<Product>();

		products.forEach(p -> {

			if ((p.isIsAuxilaryItem() == false) && (p.getComboLineItems() == null)) {

				notAuxNotComboProducts.add(p);
			}

		});

		return new PageImpl(notAuxNotComboProducts);
	}



	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findAllDeliveryTypesByStoreId(java.lang.Long, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Type> findAllDeliveryTypesByStoreId(String storeId) {
		
			SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", storeId)).build();

			Page<DeliveryInfo> deliveryinfos = elasticsearchOperations.queryForPage(searchQuery, DeliveryInfo.class);

			List<Type> types = new ArrayList<Type>();

			deliveryinfos.forEach(deliveryInfo -> {
				types.add(deliveryInfo.getType());

			});

			return types;

		}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findAllAuxilaryProducts()
	 */
	@Override
	public Page<Product> findAllAuxilaryProducts(String storeId) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("iDPcode", storeId)).build();

		 List<Product> products = elasticsearchOperations.queryForList(searchQuery, Product.class);

		 List<Product> auxilaryProducts = new ArrayList<Product>();
		 products.forEach(p->{
			 
			 if(p.isIsAuxilaryItem().equals(true)){
				 auxilaryProducts.add(p);
			 }
		 });
		 
		 return new PageImpl(auxilaryProducts);
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findProductById(java.lang.Long)
	 */
	@Override
	public Product findProductById(Long id) {
		StringQuery stringQuery = new StringQuery(termQuery("id", id).toString());
		return elasticsearchOperations.queryForObject(stringQuery, Product.class);
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findCategoryById(java.lang.Long)
	 */
	@Override
	public Category findCategoryById(Long id) {
		StringQuery stringQuery = new StringQuery(termQuery("id", id).toString());
		return elasticsearchOperations.queryForObject(stringQuery, Category.class);
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findUOMById(java.lang.Long)
	 */
	@Override
	public UOM findUOMById(Long id) {
		StringQuery stringQuery = new StringQuery(termQuery("id", id).toString());
		return elasticsearchOperations.queryForObject(stringQuery, UOM.class);
	}


	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#finAllComboLineItemsByProductId(java.lang.Long)
	 */
	@Override
	public List<ComboLineItem> finAllComboLineItemsByProductId(Long id) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("product.id", id)).build();

		return elasticsearchOperations.queryForList(searchQuery, ComboLineItem.class);
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findAllAuxilaryProductsByProductId()
	 */
	@Override
	public List<AuxilaryLineItem> findAllAuxilaryProductsByProductId(Long productId) {
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("product.id", productId)).build();

		return elasticsearchOperations.queryForList(searchQuery, AuxilaryLineItem.class);
	}

	@Override
	public Page<Banner> findBannersByStoreId(String storeId) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("store.regNo", storeId)).build();

		return elasticsearchOperations.queryForPage(searchQuery, Banner.class);
		
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findOrderByOrderId(java.lang.String)
	 */
	@Override
	public Order findOrderByOrderId(String orderId) {
		
		StringQuery stringQuery = new StringQuery(termQuery("orderId.keyword", orderId).toString());
		return elasticsearchOperations.queryForObject(stringQuery, Order.class);
	}

	/* (non-Javadoc)
	 * @see com.diviso.graeshoppe.service.QueryService#findProducts(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Product> findProducts(Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();

		return elasticsearchOperations.queryForPage(searchQuery, Product.class);
	}
	

	/*
	 * @Override public Page<Category> findAllCategories(String storeId) {
	 * 
	 * SearchQuery searchQuery = new
	 * NativeSearchQueryBuilder().withQuery(termQuery("userId",storeId)).build()
	 * ;
	 * 
	 * Page<Product> productPage =
	 * elasticsearchOperations.queryForPage(searchQuery, Product.class);
	 * 
	 * Set<Category> categorySet=new HashSet<Category>();
	 * 
	 * productPage.forEach(product->{
	 * 
	 * 
	 * categorySet.addAll(product.getCategories());
	 * 
	 * });
	 * 
	 * List<Category> categoryList=new ArrayList<Category>(categorySet);
	 * 
	 * return new PageImpl(categoryList); }
	 * 
	 */

}
