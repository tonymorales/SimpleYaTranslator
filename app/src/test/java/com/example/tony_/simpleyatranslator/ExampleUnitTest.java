package com.example.tony_.simpleyatranslator;

import com.example.tony_.simpleyatranslator.storage.model.Translation;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String LOG_TAG = "TESTING";



    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void translationObjectTest(){
        Translation translation = new Translation("1", "2", "3", "4", 1, "1");
        assertNotNull(translation);
    }

    @Test
    public void dBInsertTest(){
        Translation translation = new Translation("1", "2", "3", "4", 1, "1");
        assertNotNull(ServiceManager.getDaoSession().getTranslationDao().insert(translation));
    }

}