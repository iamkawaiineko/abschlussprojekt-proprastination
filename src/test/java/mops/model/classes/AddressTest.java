package mops.model.classes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AddressTest {

    @Test
    void testToString() {
        Address address = Address.builder()
                .city("Düsseldorf")
                .street("Universitätsstraße 1")
                .zipcode(40225)
                .country("Germany")
                .build();

        assertThat(address.toString()).isEqualTo("Address(street=Universitätsstraße 1, city=Düsseldorf, country=Germany, zipcode=40225)");
    }

    @Test
    void testBuilder() {
        Address address = Address.builder()
                .city("Düsseldorf")
                .street("Universitätsstraße 1")
                .zipcode(40225)
                .country("Germany")
                .build();

        assertThat(address)
                .hasFieldOrPropertyWithValue("city", "Düsseldorf")
                .hasFieldOrPropertyWithValue("street", "Universitätsstraße 1")
                .hasFieldOrPropertyWithValue("zipcode", 40225)
                .hasFieldOrPropertyWithValue("country", "Germany");
    }

    @Test
    void testEquals() {
        Address address1 = Address.builder()
                .city("Düsseldorf")
                .street("Universitätsstraße 1")
                .zipcode(40225)
                .country("Germany")
                .build();

        Address address2 = Address.builder()
                .city("Düsseldorf")
                .street("Universitätsstraße 1")
                .zipcode(40225)
                .country("Germany")
                .build();

        assertThat(address1).isEqualTo(address2);
    }
}