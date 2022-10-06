package com.itmaspro.orders.rest.v1.utils;

public class StringUtils {
  // tag::contains[]
  public static boolean isEmpty(String str) {

    return (str == null || "".equals(str));
  }
  public boolean contains(String haystack, String needle) {
    return haystack.contains(needle);
  }
  // end::contains[]
}
