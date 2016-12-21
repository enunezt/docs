project-new --named cdbookstore --top-level-package org.cdbookstore --target-location D:/GIT --final-name cdbookstore --version 1.0.0.Final --stack JAVA_EE_7 ;
jpa-setup --provider Hibernate --db-type H2 --data-source-name java:jboss/datasources/ExampleDS ;
jpa-new-entity --named Book ;
jpa-new-field --named title ;
jpa-new-field --named description --length 2000 ;
jpa-new-field --named price --type java.lang.Float ;
jpa-new-field --named nbOfPages --type java.lang.Integer ;
jpa-new-field --named publicationDate --type java.util.Date --temporalType DATE ;
java-new-enum --named Language --target-package org.cdbookstore.model ;
java-add-enum-const --named ENGLISH FRENCH ;
cd .. ;
cd Book.java ;
jpa-new-field --named language --type org.cdbookstore.model.Language ;
jpa-new-entity --named Author ;
jpa-new-field --named firstName ;
cd ../Book.java ;
jpa-new-field --named author --type org.cdbookstore.model.Author --relationship-type Many-to-One ;
constraint-add --constraint NotNull --on-property title ;
constraint-add --constraint Past --on-property publicationDate ;
constraint-add --on-property description --constraint Size --max 3000 ;
scaffold-generate --provider Faces --targets org.cdbookstore.model.* ;
scaffold-generate --provider Faces --targets org.cdbookstore.model.Book ;
scaffold-generate --provider Faces --targets org.cdbookstore.model.Author 
rest-generate-endpoints-from-entities --targets org.cdbookstore.model.* ;
cd D:/GIT/cdbookstore
build;
