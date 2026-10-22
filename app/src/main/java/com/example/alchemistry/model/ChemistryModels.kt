package com.example.alchemistry.model

data class LessonItem(
    val id: String,
    val name: String,
    val url: String,
    val platform: String = "youtube"
)

data class TopicCategory(
    val id: String,
    val title: String,
    val subTitle: String,
    val startColor: Long,
    val endColor: Long,
    val badgeColor: Long,
    val items: List<LessonItem>
)

data class ExternalResource(
    val title: String,
    val description: String,
    val iconEmoji: String,
    val actionText: String,
    val url: String,
    val themeColor: Long
)

object ChemistryRepository {
    val resources = listOf(
        ExternalResource(
            title = "Telegram Channel",
            description = "Get updated tute links, lecture reminders, and community discussions.",
            iconEmoji = "✈️",
            actionText = "Open Telegram",
            url = "https://t.me/+OEQXQavLod43ZmJl",
            themeColor = 0xFF0284C7
        ),
        ExternalResource(
            title = "Google Drive Folder",
            description = "Complete PDF archive containing theory tutes and structural revision papers.",
            iconEmoji = "📂",
            actionText = "Access Drive",
            url = "https://drive.google.com/drive/u/1/folders/14U9AHZA4xo-4Y8YVGyrpn07mNi_-_SKH",
            themeColor = 0xFF059669
        ),
        ExternalResource(
            title = "Charitha D. Recordings",
            description = "Direct link to Charitha Dissanayake's special recording series (Units 06 – 14).",
            iconEmoji = "🎓",
            actionText = "Watch Recordings",
            url = "https://t.me/c/2942061365/809",
            themeColor = 0xFF7C3AED
        )
    )

    val categories = listOf(
        TopicCategory(
            id = "inorganic",
            title = "Inorganic Chemistry",
            subTitle = "අකාබනික රසායනය",
            startColor = 0xFF3B82F6,
            endColor = 0xFF4F46E5,
            badgeColor = 0xFF2563EB,
            items = listOf(
                LessonItem("inorg_1", "Inorganic Lesson 01", "https://youtu.be/3Y6VKZP2zAQ"),
                LessonItem("inorg_2", "Inorganic Lesson 02", "https://youtu.be/lPOVYwc7pwQ"),
                LessonItem("inorg_3", "Inorganic Lesson 03", "https://youtu.be/HhMEqhLwCdc"),
                LessonItem("inorg_4", "Inorganic Lesson 04", "https://youtu.be/zclyf1kQAXk"),
                LessonItem("inorg_5", "Inorganic Lesson 05", "https://youtu.be/kD1w4c5Oswc"),
                LessonItem("inorg_6", "Inorganic Lesson 06", "https://youtu.be/jBeOmFsVppk"),
                LessonItem("inorg_7", "Inorganic Lesson 07", "https://youtu.be/j9SnMSpPIc8"),
                LessonItem("inorg_8", "Inorganic Lesson 08", "https://youtu.be/FRTNCA6q9ME"),
                LessonItem("inorg_9", "Inorganic Lesson 09", "https://youtu.be/TdvYzVkHUO4"),
                LessonItem("inorg_10", "Inorganic Lesson 10", "https://youtu.be/jIsbs2KfP5c"),
                LessonItem("inorg_11", "Inorganic Lesson 11", "https://youtu.be/bjuaZ86RVzk"),
                LessonItem("inorg_12", "Inorganic Lesson 12", "https://youtu.be/ZYkiiWqGYUI")
            )
        ),
        TopicCategory(
            id = "kinetics",
            title = "Chemical Kinetics",
            subTitle = "රසායනික චාලක විද්‍යාව",
            startColor = 0xFF10B981,
            endColor = 0xFF0D9488,
            badgeColor = 0xFF059669,
            items = listOf(
                LessonItem("kin_1", "Day 01 — Part 01", "https://rumble.com/v74ureo-kinetic-day-01-p01.html", "rumble"),
                LessonItem("kin_2", "Day 01 — Part 02", "https://rumble.com/v74urtm-chemical-kinetics-day-01-p02.html", "rumble"),
                LessonItem("kin_3", "Day 02 — Part 01", "https://rumble.com/v74urzc-chemical-kinetics-day-02-p01.html", "rumble"),
                LessonItem("kin_4", "Day 02 — Part 02", "https://rumble.com/v74us2i-chemical-kinetics-day-02-p02.html", "rumble"),
                LessonItem("kin_5", "Day 03 — Part 01", "https://rumble.com/v74us68-chemical-kinetics-day-03-p02.html", "rumble"),
                LessonItem("kin_6", "Day 03 — Part 02", "https://rumble.com/v74us68-chemical-kinetics-day-03-p02.html", "rumble"),
                LessonItem("kin_7", "Day 04 — Part 01", "https://rumble.com/v74ut3i-chemical-kinetics-day-04-p01.html", "rumble"),
                LessonItem("kin_8", "Day 04 — Part 02", "https://rumble.com/v74utv0-chemical-kinetics-day-04-p02.html", "rumble"),
                LessonItem("kin_9", "Day 05 — Part 01", "https://rumble.com/v74utzc-chemical-kinetics-day-05-p01.html", "rumble"),
                LessonItem("kin_10", "Day 05 — Part 02", "https://rumble.com/v74uu3c-chemical-kinetics-day-05-p02.html", "rumble"),
                LessonItem("kin_11", "Day 06 — Part 01", "https://rumble.com/v74lf9q-chemical-kinetics-06-p01.html", "rumble"),
                LessonItem("kin_12", "Day 06 — Part 02", "https://rumble.com/v74mf6i-chemical-kinetics-06-p02.html", "rumble")
            )
        ),
        TopicCategory(
            id = "organic",
            title = "Organic Chemistry",
            subTitle = "කාබනික රසායනය",
            startColor = 0xFF8B5CF6,
            endColor = 0xFFEC4899,
            badgeColor = 0xFF7C3AED,
            items = listOf(
                LessonItem("org_1", "Organic Day 01 — Part 1", "https://rumble.com/v74uula-organic-day-01.html", "rumble"),
                LessonItem("org_2", "Organic Day 01 — Part 2", "https://rumble.com/v74uwwa-organic-day-01-p02.html", "rumble"),
                LessonItem("org_3", "Organic Day 02 — Part 1", "https://rumble.com/v74uypg-organic-day-02-p01.html", "rumble"),
                LessonItem("org_4", "Organic Day 02 — Part 2", "https://rumble.com/v74uz3y-organic-day-02-p02.html", "rumble"),
                LessonItem("org_5", "Organic Day 03 — Part 1", "https://rumble.com/v74v1s4-organic-day-03-p01.html", "rumble"),
                LessonItem("org_6", "Organic Day 03 — Part 2", "https://rumble.com/v74v2c0-organic-day-03-p02.html", "rumble"),
                LessonItem("org_7", "Organic Day 04 — Part 1", "https://rumble.com/v74v3ie-organic-day-04-p01.html", "rumble"),
                LessonItem("org_8", "Organic Day 04 — Part 2", "https://rumble.com/v74v3sq-organic-day-04-p02.html", "rumble"),
                LessonItem("org_9", "Organic Day 05 — Part 1", "https://rumble.com/v74mhhi-organic-day-05-p01.html", "rumble"),
                LessonItem("org_10", "Organic Day 05 — Part 2", "https://rumble.com/v74lly2-chemical-kinetics-day-06-p02.html", "rumble"),
                LessonItem("org_11", "Organic Day 06 — Part 1", "https://rumble.com/v74ztla-organic-day-06-p01.html", "rumble"),
                LessonItem("org_12", "Organic Day 06 — Part 2", "https://rumble.com/v74zu6k-organic-day-06-p02.html", "rumble"),
                LessonItem("org_13", "Organic Day 07 — Part 1", "https://rumble.com/v75d11w-organic-day-07-p01.html", "rumble"),
                LessonItem("org_14", "Organic Day 07 — Part 2", "https://rumble.com/v75d2x2-organic-day-07-p02.html", "rumble"),
                LessonItem("org_15", "Organic Day 08 — Part 1", "https://youtu.be/5qaY6Su7ITU"),
                LessonItem("org_16", "Organic Day 08 — Part 2", "https://youtu.be/-9HC6V-asv4"),
                LessonItem("org_17", "Organic Day 09 — Part 1", "https://youtu.be/uXwUW78slFw"),
                LessonItem("org_18", "Organic Day 09 — Part 2", "https://youtu.be/n7rpvp9ZSp4"),
                LessonItem("org_19", "Organic Day 10", "https://youtu.be/hHQLJBGcjCc"),
                LessonItem("org_20", "Organic Day 11", "https://youtu.be/INrsNJi9Ddw"),
                LessonItem("org_21", "Organic Day 12", "https://youtu.be/ACB22wuFX4M"),
                LessonItem("org_22", "Organic Day 13", "https://youtu.be/LfQQPbHaGwY"),
                LessonItem("org_23", "Organic Day 14", "https://youtu.be/biuNbnnGWsQ"),
                LessonItem("org_24", "Organic Day 15", "https://youtu.be/6r2GNeBr6JE"),
                LessonItem("org_25", "Organic Day 16", "https://youtu.be/bbNmEWwNtCU"),
                LessonItem("org_26", "Organic Day 17", "https://youtu.be/LFd6je0NNec"),
                LessonItem("org_27", "Organic Day 18", "https://youtu.be/7avFu6yrPLM"),
                LessonItem("org_28", "Organic Day 19", "https://youtu.be/9OewZoeLFVw"),
                LessonItem("org_29", "Organic Day 20", "https://youtu.be/8Ea6jshluIE"),
                LessonItem("org_30", "Organic Day 21", "https://youtu.be/rewPK6XGJws"),
                LessonItem("org_31", "Organic Day 22", "https://youtu.be/4PAusH1yK5c"),
                LessonItem("org_32", "Organic Day 23", "https://youtu.be/ggW3vS8Su4s"),
                LessonItem("org_33", "Organic Day 24", "https://youtu.be/ggW3vS8Su4s"),
                LessonItem("org_34", "Organic Day 25", "https://youtu.be/PZvkmIbDg4g"),
                LessonItem("org_35", "Organic Day 26", "https://youtu.be/7ma73P0fXTc"),
                LessonItem("org_36", "Organic Day 27", "https://youtu.be/Q0ueEbmADhw"),
                LessonItem("org_37", "Organic Day 28", "https://youtu.be/Qccf-Oh-6G0"),
                LessonItem("org_38", "Organic Day 29", "https://youtu.be/FFZJlYU06rs"),
                LessonItem("org_39", "Organic Day 30", "https://youtu.be/1CQ92qbUzkQ")
            )
        ),
        TopicCategory(
            id = "equilibrium",
            title = "Equilibrium — Kp & Kc",
            subTitle = "සමතුලිතතාවය",
            startColor = 0xFFF59E0B,
            endColor = 0xFFEA580C,
            badgeColor = 0xFFD97706,
            items = listOf(
                LessonItem("eq_1", "Day 01 — Part 1", "https://rumble.com/v74zrv8-equilibrium-day-01-p01.html", "rumble"),
                LessonItem("eq_2", "Day 01 — Part 2", "https://rumble.com/v74yggw-eequilibrium-01-p02.html", "rumble"),
                LessonItem("eq_3", "Day 02 — Part 1", "https://youtu.be/lb5qz88luz8"),
                LessonItem("eq_4", "Day 02 — Part 2", "https://youtu.be/Y6BSmxy45gs"),
                LessonItem("eq_5", "Day 03", "https://youtu.be/c7ii6P7kdus"),
                LessonItem("eq_6", "Day 04", "https://youtu.be/6BmevmWrQDU"),
                LessonItem("eq_7", "Day 05", "https://youtu.be/AlcZg8Sb78A"),
                LessonItem("eq_8", "Day 06", "https://youtu.be/AlcZg8Sb78A"),
                LessonItem("eq_9", "Day 07", "https://youtu.be/N51Gan12x3g"),
                LessonItem("eq_10", "Day 08", "https://youtu.be/KZGeFPzKbhk")
            )
        ),
        TopicCategory(
            id = "solubility",
            title = "Solubility Product (Ksp)",
            subTitle = "ද්‍රාව්‍යතා ගුණිතය",
            startColor = 0xFFEAB308,
            endColor = 0xFFD97706,
            badgeColor = 0xFFCA8A04,
            items = listOf(
                LessonItem("sol_1", "Solubility Day 01", "https://youtu.be/DBPER9uVb9E"),
                LessonItem("sol_2", "Solubility Day 02", "https://youtu.be/y-_E1wGuTHQ"),
                LessonItem("sol_3", "Solubility Day 03", "https://youtu.be/JeUXugb2pGI"),
                LessonItem("sol_4", "Solubility Day 04", "https://youtu.be/AV7JgRM96JE"),
                LessonItem("sol_5", "Solubility Day 05 (Live)", "https://www.youtube.com/live/WyZzvNSkqRc")
            )
        ),
        TopicCategory(
            id = "buffer",
            title = "Buffer & Region Equilibrium",
            subTitle = "කලාප සමතුලිතතාවය",
            startColor = 0xFFF43F5E,
            endColor = 0xFFDC2626,
            badgeColor = 0xFFE11D48,
            items = listOf(
                LessonItem("buf_1", "Buffer Day 01", "https://youtu.be/W1_HQ-YLtYA"),
                LessonItem("buf_2", "Buffer Day 02", "https://youtu.be/lkisWtdBU5M"),
                LessonItem("buf_3", "Buffer Day 03", "https://youtu.be/jxPuvRm1WD8"),
                LessonItem("buf_4", "Buffer Day 04", "https://youtu.be/NPmQjrZnD0o"),
                LessonItem("buf_5", "Buffer Day 05", "https://youtu.be/vhT9dfXw2Mc"),
                LessonItem("buf_6", "Buffer Day 06", "https://youtu.be/wzbHqIFEG9k"),
                LessonItem("buf_7", "Buffer Day 07", "https://youtu.be/0ZpjEtTTBes"),
                LessonItem("buf_8", "Buffer Day 08", "https://youtu.be/loij6uiedh0")
            )
        ),
        TopicCategory(
            id = "ph",
            title = "pH & Aqueous Solutions",
            subTitle = "pH අගය හා ජලීය ද්‍රාවණ",
            startColor = 0xFF06B6D4,
            endColor = 0xFF2563EB,
            badgeColor = 0xFF0891B2,
            items = listOf(
                LessonItem("ph_1", "pH Day 01", "https://youtu.be/5plY8aplLu0"),
                LessonItem("ph_2", "pH Day 02", "https://youtu.be/XC4nPblkkSM"),
                LessonItem("ph_3", "pH Day 03", "https://youtu.be/mmTfyJJvSos"),
                LessonItem("ph_4", "pH Day 04", "https://youtu.be/BfmiYFO1P48"),
                LessonItem("ph_5", "pH Day 05 — Part 1", "https://youtu.be/4eklUzW2SQY"),
                LessonItem("ph_6", "pH Day 05 — Part 2", "https://youtu.be/QeQsyRYooZ8"),
                LessonItem("ph_7", "pH Day 06", "https://youtu.be/slHJzA-bTi0"),
                LessonItem("ph_8", "pH Day 07", "https://youtu.be/LKXfj12OLdw"),
                LessonItem("ph_9", "pH Day 08", "https://youtu.be/d8xuWny5iNM"),
                LessonItem("ph_10", "pH Day 09", "https://youtu.be/hAPNSvF50kw")
            )
        ),
        TopicCategory(
            id = "electrochem",
            title = "Electrochemistry",
            subTitle = "විද්‍යුත් රසායනය",
            startColor = 0xFFF97316,
            endColor = 0xFFD97706,
            badgeColor = 0xFFEA580C,
            items = listOf(
                LessonItem("el_1", "Electrochemistry Day 01", "https://youtu.be/DpChsSFOnnw"),
                LessonItem("el_2", "Electrochemistry Day 02", "https://youtu.be/AUeEmx-Rqu4"),
                LessonItem("el_3", "Electrochemistry Day 03", "https://youtu.be/PGEUaVpZaN8"),
                LessonItem("el_4", "Electrochemistry Day 04", "https://youtu.be/kIgEyr8d97w"),
                LessonItem("el_5", "Electrochemistry Day 05", "https://youtu.be/TaUj10co0MI"),
                LessonItem("el_6", "Electrochemistry Day 06", "https://youtu.be/yhwKpKNthYM"),
                LessonItem("el_7", "Electrochemistry Day 07", "https://www.youtube.com/watch?v=WyZzvNSkqRc")
            )
        ),
        TopicCategory(
            id = "industrial",
            title = "Industrial Chemistry",
            subTitle = "කාර්මික රසායනය",
            startColor = 0xFF14B8A6,
            endColor = 0xFF059669,
            badgeColor = 0xFF0D9488,
            items = listOf(
                LessonItem("ind_1", "Magnesium Extraction (Mg)", "https://www.youtube.com/watch?v=NIH5MZ4rM0s"),
                LessonItem("ind_2", "Titanium Dioxide Production (TiO₂)", "https://www.youtube.com/watch?v=lZawFPb9UHA"),
                LessonItem("ind_3", "Sodium Hydroxide Production (NaOH)", "https://www.youtube.com/watch?v=Qglm_IAy-j0"),
                LessonItem("ind_4", "Iron Production (යකඩ)", "https://www.youtube.com/watch?v=pvNsGvtjHpI"),
                LessonItem("ind_5", "Soap Production (සබන්)", "https://www.youtube.com/watch?eZ79cEU8zSc"),
                LessonItem("ind_6", "Polymer Production — Day 01", "https://www.youtube.com/watch?v=o3pSLd3TnTE"),
                LessonItem("ind_7", "Polymer Production — Day 02", "https://www.youtube.com/watch?v=TYv18TdQ-QE"),
                LessonItem("ind_8", "Ammonia Production (NH₃)", "https://www.youtube.com/watch?v=BuSKE2YdHwQ"),
                LessonItem("ind_9", "Plant-based Products — Day 01", "https://www.youtube.com/watch?v=k9M9TqNbJHs"),
                LessonItem("ind_10", "Plant-based Products — Day 02", "https://www.youtube.com/watch?v=4H3Z6BdNOl8"),
                LessonItem("ind_11", "Nitric Acid Production (HNO₃)", "https://www.youtube.com/watch?v=yS8kHSNIkww"),
                LessonItem("ind_12", "Sulfuric Acid Production (H₂SO₄)", "https://www.youtube.com/watch?v=geMS0F14A4Q"),
                LessonItem("ind_13", "Industrial Questions — Day 01", "https://www.youtube.com/watch?v=YWbJiLtCss0"),
                LessonItem("ind_14", "Industrial Questions — Day 02", "https://www.youtube.com/watch?v=HNVtbpXHCRk"),
                LessonItem("ind_15", "Industrial Questions — Day 03", "https://www.youtube.com/watch?v=aV7k59P2Two"),
                LessonItem("ind_16", "Industrial Discussion", "https://www.youtube.com/watch?v=6rMkRN1drgs")
            )
        )
    )

    val totalLessonsCount: Int = categories.sumOf { it.items.size }
}
