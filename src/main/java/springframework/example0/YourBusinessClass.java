package springframework.example0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
    private static final Log LOG = LogFactory.getLog(YourBusinessClass.class);

    private final Dependency1 dependency1;
    private final Dependency2 dependency2;

    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        LOG.info("constructor");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        LOG.info("setDependency1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        LOG.info("setDependency2");
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "YourBusinessClass{" + "dependency1=" + dependency1 + ", dependency2=" + dependency2 + '}';
    }

}
