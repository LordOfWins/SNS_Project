package org.springstudy.restfulweb.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {
  @GetMapping("/v1/person")
  public PersonV1 getFirstPerson() {
    return new PersonV1("Bob");
  }

  @GetMapping("/v2/person")
  public PersonV2 getSecondPerson() {
    return new PersonV2(new Name("Bob", "Chalie"));
  }

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getParamFirstPerson() {
    return new PersonV1("Bob");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getParamSecondPerson() {
    return new PersonV2(new Name("Bob", "Chalie"));
  }

  @GetMapping(path = "/person/header", headers = "X-Version=1")
  public PersonV1 getHeaderVersionFirstPerson() {
    return new PersonV1("Bob");
  }

  @GetMapping(path = "/person/header", headers = "X-Version=2")
  public PersonV2 getHeaderVersionSecondPerson() {
    return new PersonV2(new Name("Bob", "Chalie"));
  }

  @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
  public PersonV1 getAcceptHeaderFirstPerson() {
    return new PersonV1("Bob");
  }

  @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
  public PersonV2 getAcceptHeaderSecondPerson() {
    return new PersonV2(new Name("Bob", "Chal"));
  }
}