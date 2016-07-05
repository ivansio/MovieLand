package com.luxoft.movieland.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Red5 on 30.06.2016.
 */
public class JsonJacksonConverterTest {

    @Test
    public void testParseMovie() {
        String json = "{\"id\":\"1\", \"name\":\"Побег из Шоушенка\", \"englishName\":\"The Shawshank Redemption\", \"year\":\"1994\", \"countryList\":[], \"genreList\":[\"драма\", \"криминал\"], \"description\":\"Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.\", \"rating\":\"8.9\", \"price\":\"0.0\", \"reviewList\":\"null\"}";
        JsonJacksonConverter jsonJacksonConverter = new JsonJacksonConverter();

    }

}