package com.example.so69898042;

import java.util.UUID;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@NamedNativeQuery(name = "CustomerEntity.findOnlyNameAndPhoneFromCustomer",
    query = "select customer_name, customer_email from customer",
    resultSetMapping = "nativeMapping")

@SqlResultSetMappings(value = {
    @SqlResultSetMapping(name = "nativeMapping",
        entities = {
            @EntityResult(
                entityClass = CustomerEntity.class,
                fields = {
                    @FieldResult(name = "name", column = "customer_name"),
                    @FieldResult(name = "email", column = "customer_email")
                }) }) })
@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {
    //getter and setter fields
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "address")
    private String adddress;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    @Column(columnDefinition = "VARCHAR(36)", name = "customer_guid")
    @Type(type = "uuid-char")
    private UUID guid;
    //    @Embedded
    //    private AuditFields audit;
}
