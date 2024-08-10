package com.example.amphibiansapp.fake

import com.example.amphibiansapp.model.Card

object Fake {


    val fakeDatasource = listOf(
        Card(
            name = "Dragon Slayer",
            type = "Weapon",
            description = "A legendary sword with the power to slay dragons.",
            imgSrc = "https://example.com/images/dragon_slayer.png"
        ),
        Card(
            name = "Healing Potion",
            type = "Potion",
            description = "Restores health and cures minor wounds.",
            imgSrc = "https://example.com/images/healing_potion.png"
        ),
        Card(
            name = "Mystic Amulet",
            type = "Accessory",
            description = "An amulet with magical properties that boosts defense.",
            imgSrc = "https://example.com/images/mystic_amulet.png"
        ),
        Card(
            name = "Fireball Scroll",
            type = "Spell",
            description = "A scroll containing a powerful fireball spell.",
            imgSrc = "https://example.com/images/fireball_scroll.png"
        ),
        Card(
            name = "Elven Bow",
            type = "Weapon",
            description = "A finely crafted bow favored by elves, known for its accuracy.",
            imgSrc = "https://example.com/images/elven_bow.png"
        )
    )
}