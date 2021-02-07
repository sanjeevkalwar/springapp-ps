package com.footballleague.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.hateoas.RepresentationModel;

import com.footballleague.utils.LinkBuilder;

@SuppressWarnings("serial")
public class Results<K> extends RepresentationModel implements Serializable {
	private final Map<String, K> results;

	@SafeVarargs
	public Results(Map<String, K> results, LinkBuilder<K>... linkBuilders) {
		super();
		this.results = results;
		if (linkBuilders != null && linkBuilders.length > 0) {
			for (LinkBuilder<K> linkBuilder : linkBuilders) {
				add(linkBuilder.transform(results));
			}
		}
	}

	public Map<String, K> getResults() {
		return results;
	}
}
