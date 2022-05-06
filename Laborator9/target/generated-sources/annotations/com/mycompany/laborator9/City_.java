package com.mycompany.laborator9;

import com.mycompany.laborator9.Country;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-06T22:21:12", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, Country> country;
    public static volatile SingularAttribute<City, Integer> capital;
    public static volatile SingularAttribute<City, Float> latitude;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, Integer> id;
    public static volatile SingularAttribute<City, Float> longitude;

}