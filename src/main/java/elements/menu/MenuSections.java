package elements.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MenuSections {
    BAGGAGE_DELIVERY("Доставка багажа"),
    REQUESTS("Заявки"),
    FLIGHTS("Рейсы"),
    REFUELING("Заправка");

    private String name;
}
