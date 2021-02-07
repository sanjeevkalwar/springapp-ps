package com.footballleague.utils;

import java.util.Map;


import org.springframework.hateoas.Link;

public interface LinkBuilder<T> {
	Link transform(Map<String, T> map);
}
