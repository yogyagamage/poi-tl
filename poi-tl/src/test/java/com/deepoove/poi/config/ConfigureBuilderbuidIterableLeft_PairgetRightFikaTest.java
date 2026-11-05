package com.deepoove.poi.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

public class ConfigureBuilderbuidIterableLeft_PairgetRightFikaTest {

    @Test
    void testBuidIterableLeft() throws Exception {
        Constructor<?> configConstructor = Configure.class.getDeclaredConstructor();
        configConstructor.setAccessible(true);
        Configure config = (Configure) configConstructor.newInstance();

        Field iterableField = null;
        Class<?> current = Configure.class;
        while (current != null && iterableField == null) {
            try {
                iterableField = current.getDeclaredField("iterable");
            } catch (NoSuchFieldException ignored) {
            }
            if (iterableField == null) {
                for (Field field : current.getDeclaredFields()) {
                    if (Pair.class.isAssignableFrom(field.getType())) {
                        iterableField = field;
                        break;
                    }
                }
            }
            current = current.getSuperclass();
        }
        if (iterableField == null) {
            throw new NoSuchFieldException("iterable");
        }
        iterableField.setAccessible(true);
        iterableField.set(config, Pair.of('a', (Iterable<?>) null));

        ConfigureBuilder builder = null;
        for (Constructor<?> constructor : ConfigureBuilder.class.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == Configure.class) {
                constructor.setAccessible(true);
                builder = (ConfigureBuilder) constructor.newInstance(config);
                break;
            }
        }
        if (builder == null) {
            for (Constructor<?> constructor : ConfigureBuilder.class.getDeclaredConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(Configure.class)) {
                    constructor.setAccessible(true);
                    builder = (ConfigureBuilder) constructor.newInstance(config);
                    break;
                }
            }
        }
        if (builder == null) {
            for (Constructor<?> constructor : ConfigureBuilder.class.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 0) {
                    constructor.setAccessible(true);
                    builder = (ConfigureBuilder) constructor.newInstance();
                    break;
                }
            }
        }
        if (builder == null) {
            Method factory = null;
            current = ConfigureBuilder.class;
            while (current != null && factory == null) {
                Method candidate = null;
                try {
                    candidate = current.getDeclaredMethod("builder");
                } catch (NoSuchMethodException ignored) {
                }
                if (candidate != null && Modifier.isStatic(candidate.getModifiers())) {
                    factory = candidate;
                    break;
                }
                current = current.getSuperclass();
            }
            if (factory != null) {
                factory.setAccessible(true);
                builder = (ConfigureBuilder) factory.invoke(null);
            }
            if (builder == null) {
                factory = null;
                current = Configure.class;
                while (current != null && factory == null) {
                    Method candidate = null;
                    try {
                        candidate = current.getDeclaredMethod("builder");
                    } catch (NoSuchMethodException ignored) {
                    }
                    if (candidate != null && Modifier.isStatic(candidate.getModifiers())) {
                        factory = candidate;
                        break;
                    }
                    current = current.getSuperclass();
                }
                if (factory != null) {
                    factory.setAccessible(true);
                    builder = (ConfigureBuilder) factory.invoke(null);
                }
            }
        }
        if (builder == null) {
            throw new NoSuchMethodException("ConfigureBuilder");
        }

        Field configField = null;
        current = ConfigureBuilder.class;
        while (current != null && configField == null) {
            try {
                configField = current.getDeclaredField("config");
            } catch (NoSuchFieldException ignored) {
            }
            if (configField == null) {
                for (Field field : current.getDeclaredFields()) {
                    if (Configure.class.isAssignableFrom(field.getType())) {
                        configField = field;
                        break;
                    }
                }
            }
            current = current.getSuperclass();
        }
        if (configField != null) {
            configField.setAccessible(true);
            Object existing = configField.get(builder);
            if (existing == null) {
                try {
                    configField.set(builder, config);
                } catch (IllegalAccessException ignored) {
                }
                existing = configField.get(builder);
            }
            if (existing != null && existing != config) {
                iterableField.set(existing, Pair.of('a', (Iterable<?>) null));
            }
        }

        builder.buidIterableLeft('a');
    }
}
