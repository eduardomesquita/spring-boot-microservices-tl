package crawlertl.admin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Customer {

    @Id Integer id;
    String firstname;
    String lastname;

}
