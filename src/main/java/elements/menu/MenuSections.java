package elements.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MenuSections {
    REQUESTS_RA("Заявки РА"),
    REQUESTS("Заявки"),
    FLIGHTS("Рейсы"),
    REFUELING("Заправка");

    private String name;
}
