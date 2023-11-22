package org.springstudy.mokito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BusinessImplStubTest {
  @Test
  void findTheGreatestFromAllData() {
    DataService dataServiceStub = new DataServiceStub1();
    BusinessImpl business = new BusinessImpl(dataServiceStub);
    assertEquals(25, business.findTheGreatestFromAllData());
  }

  @Test
  void findTheGreatestFromAllData_withOneValue() {
    DataService dataServiceStub = new DataServiceStub2();
    BusinessImpl businessImpl = new BusinessImpl(dataServiceStub);
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(35, result);
  }
}

class DataServiceStub1 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {25, 15, 5};
  }
}

class DataServiceStub2 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {35};
  }
}