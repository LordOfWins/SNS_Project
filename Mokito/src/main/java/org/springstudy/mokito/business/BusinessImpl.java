package org.springstudy.mokito.business;

interface DataService {
  int[] retrieveAllData();
}

public class BusinessImpl {
  private final DataService dataService;

  public BusinessImpl(DataService dataService) {
    super();
    this.dataService = dataService;
  }

  public int findTheGreatestFromAllData() {
    int[] data = dataService.retrieveAllData();
    int greatestValue = Integer.MIN_VALUE;
    for (int value : data) {
      if (value > greatestValue) greatestValue = value;
    }
    return greatestValue;
  }
}