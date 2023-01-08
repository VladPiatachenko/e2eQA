package edu.sumdu.tss.elephant.controller;

import edu.sumdu.tss.elephant.helper.Keys;
import edu.sumdu.tss.elephant.model.User;


import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import io.javalin.http.Context;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.util.TreeMap;

import edu.sumdu.tss.elephant.controller.ProfileController;
import edu.sumdu.tss.elephant.controller.AbstractController;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ProfileControllerIntegrationTest {
    final static Context ctx = Mockito.mock(Context.class);
    final static User user = new User();

    @BeforeClass
    static void setUp() {
        Keys.loadParams(new File("src\\main\\resources\\ta.conf"));
        ctx.sessionAttribute("model", new TreeMap<String, Object>());
        ctx.sessionAttribute(Keys.LANG_KEY, null);
        user.setId(54689L);
        user.setRole(1L);
        user.setUsername("postgres");
        user.setLogin("postgres");
        user.setPassword("test");
        user.setPrivateKey("iuhfeoewjidq");
        user.setPublicKey("oeisusgoeifw");
        user.setDbPassword("16022001");
        user.setLanguage("EN");
        user.setToken("oidsofijdo");
    }

    @Test
    void show() {
        edu.sumdu.tss.elephant.controller.ProfileController.show(ctx);
        verify(ctx).render("/velocity/profile/show.vm", AbstractController.currentModel(ctx));
    }
    @Test
    void upgradeUser() {
        when(ctx.formParam("role")).thenReturn(user.role().toString());
        when(ctx.sessionAttribute(Keys.SESSION_CURRENT_USER_KEY)).thenReturn(user);
        ProfileController.upgradeUser(ctx);
        verify(ctx).redirect("/profile");
    }

}
