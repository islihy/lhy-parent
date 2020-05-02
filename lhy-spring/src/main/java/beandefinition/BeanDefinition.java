package beandefinition;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ly
 **/
public interface BeanDefinition {

    String SINGLETION = "singleton";

    String PROTOTYPE = "prototype";

    /**
     * @return
     */
    Class<?> getBeanClass();

    /**
     * @return
     */
    String getBeanFactory();

    /**
     * @return
     */
    String getCreateBeanMethod();

    String getStaticCreateBeanMethod();

    String getBeanInitMethodName();

    String getBeanDestoryMethodName();

    /**
     * @return
     */
    String getScope();

    boolean isSingleton();

    boolean isPrototype();

    /**
     * @return
     */
    default boolean validate(){

        if(getBeanClass() == null){
            if(StringUtils.isBlank(getBeanFactory()) && StringUtils.isBlank(getCreateBeanMethod())){
                return false;
            }
        }
        return true;
    }

}
