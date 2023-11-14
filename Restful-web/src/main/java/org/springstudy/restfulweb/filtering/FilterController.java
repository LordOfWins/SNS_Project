package org.springstudy.restfulweb.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
  private static void mappingJackson(String field2, MappingJacksonValue mappingJacksonValue) {
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(field2, "field3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    mappingJacksonValue.setFilters(filters);
  }

  @GetMapping("/filtering")
  public MappingJacksonValue filtering() {
    SomeBean someBean = new SomeBean("field1", "field2", "field3");
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
    mappingJackson("field1", mappingJacksonValue);

    return mappingJacksonValue;
  }

  @GetMapping("/filtering-list")
  public MappingJacksonValue filteringList() {
    List<SomeBean> someBean =
        Arrays.asList(
            new SomeBean("field1", "field2", "field3"), new SomeBean("field4", "field5", "field6"));
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
    mappingJackson("field2", mappingJacksonValue);
    return mappingJacksonValue;
  }
}