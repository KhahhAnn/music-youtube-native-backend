//package vn.khahhann.musicyoutubebackend.config;
//
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.metamodel.Type;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import vn.khahhann.musicyoutubebackend.entity.User;
//
//@Configuration
//public class MethodRestConfig implements RepositoryRestConfigurer {
//    private String url = "http://localhost:35729";
//    @Autowired
//    private EntityManager entityManager;
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        config.exposeIdsFor(
//                entityManager.getMetamodel()
//                        .getEntities()
//                        .stream().map(Type::getJavaType)
//                        .toArray(Class[]::new)
//        );
//
//        cors.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE");
//
////        HttpMethod[] blockDelete = {
////                HttpMethod.DELETE,
////                HttpMethod.POST,
////                HttpMethod.PATCH,
////                HttpMethod.PUT
////        };
////        blockHttpMethods(User.class, config, blockDelete);
//
//    }
////    private void blockHttpMethods(Class c, RepositoryRestConfiguration configuration, HttpMethod[] methods) {
////        configuration.getExposureConfiguration()
////                .forDomainType(c)
////                .withItemExposure((metdata, httpMethods) -> httpMethods.disable((methods)))
////                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
////    }
//}
