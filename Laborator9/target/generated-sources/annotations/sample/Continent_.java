package sample;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sample.Country;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-06T23:21:55", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Continent.class)
public class Continent_ { 

    public static volatile SingularAttribute<Continent, String> name;
    public static volatile CollectionAttribute<Continent, Country> countryCollection;
    public static volatile SingularAttribute<Continent, Integer> id;

}