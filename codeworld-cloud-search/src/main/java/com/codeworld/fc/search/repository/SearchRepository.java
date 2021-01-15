package com.codeworld.fc.search.repository;

import com.codeworld.fc.search.item.SearchItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface SearchRepository extends ElasticsearchRepository<SearchItem, Long> {
}
