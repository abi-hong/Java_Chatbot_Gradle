package com.example.chatbotproject.dto.res.order;

import com.example.chatbotproject.entity.Menu;
import lombok.*;
import sun.nio.cs.ext.MacUkraine;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListResponseDto {

    /*
    private String menu_name;
    private int menu_price;

    private ChatbotOrderMenuListResponseDto(Menu menu) {
        this.menu_name = menu.getMenu_name();
        this.menu_price = menu.getMenu_price();
    }

    public static ChatbotOrderMenuListResponseDto of(Menu menu) {
        return new ChatbotOrderMenuListResponseDto(menu);
    }
    */

    private List<Menu> menuList;

    private ChatbotOrderMenuListResponseDto(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public static ChatbotOrderMenuListResponseDto of(List<Menu> menuList) {
        return new ChatbotOrderMenuListResponseDto(menuList);
    }
}
