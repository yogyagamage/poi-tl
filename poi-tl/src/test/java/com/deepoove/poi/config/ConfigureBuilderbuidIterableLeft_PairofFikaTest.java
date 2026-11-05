package com.deepoove.poi.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

public class ConfigureBuilderbuidIterableLeft_PairofFikaTest {

    @Test
    public void testBuidIterableLeft() throws Exception {
        Object builder = createInstance(ConfigureBuilder.class);
        Class<?> builderClass = builder.getClass();

        Object config = ensureConfig(builder, builderClass);
        ensureIterable(config);

        Method method = findMethod(builderClass, "buidIterableLeft", char.class);
        if (method == null) {
            method = findMethod(builderClass, "buidIterableLeft", Character.class);
        }
        if (method == null) {
            method = builderClass.getMethod("buidIterableLeft", char.class);
        }

        try {
            method.setAccessible(true);
        } catch (Exception ignored) {
        }

        method.invoke(builder, 'x');
    }

    private static Object ensureConfig(Object builder, Class<?> builderClass) {
        Object config = null;
        try {
            Field configField = findField(builderClass, "config");
            if (configField != null) {
                try {
                    configField.setAccessible(true);
                } catch (Exception ignored) {
                }

                config = configField.get(builder);
                if (config == null) {
                    Object created = createInstance(configField.getType());
                    if (created != null) {
                        config = created;
                        try {
                            configField.set(builder, config);
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return config;
    }

    private static void ensureIterable(Object config) {
        if (config == null) {
            return;
        }

        try {
            Field iterableField = findField(config.getClass(), "iterable");
            if (iterableField != null) {
                try {
                    iterableField.setAccessible(true);
                } catch (Exception ignored) {
                }

                try {
                    iterableField.set(config, new ImmutablePair<Character, Character>('a', 'b'));
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ignored) {
        }
    }

    private static Object createInstance(Class<?> type) throws Exception {
        Exception last = null;

        Constructor<?> constructor = findConstructor(type);
        if (constructor != null) {
            try {
                constructor.setAccessible(true);
            } catch (Exception ignored) {
            }

            try {
                return constructor.newInstance();
            } catch (Exception e) {
                last = e;
            }
        }

        Method factory = findStaticFactory(type);
        if (factory != null) {
            try {
                factory.setAccessible(true);
            } catch (Exception ignored) {
            }

            try {
                return factory.invoke(null);
            } catch (Exception e) {
                last = e;
            }
        }

        Object allocated = allocateInstance(type);
        if (allocated != null) {
            return allocated;
        }

        if (last != null) {
            throw last;
        }

        return null;
    }

    private static Constructor<?> findConstructor(Class<?> type) {
        try {
            return type.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static Method findStaticFactory(Class<?> type) {
        while (type != null) {
            for (Method method : type.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers())
                        && type.isAssignableFrom(method.getReturnType())
                        && method.getParameterCount() == 0) {
                    return method;
                }
            }
            type = type.getSuperclass();
        }
        return null;
    }

    private static Field findField(Class<?> type, String name) {
        while (type != null) {
            try {
                return type.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                type = type.getSuperclass();
            }
        }
        return null;
    }

    private static Method findMethod(Class<?> type, String name, Class<?>... parameterTypes) {
        while (type != null) {
            try {
                return type.getDeclaredMethod(name, parameterTypes);
            } catch (NoSuchMethodException e) {
                type = type.getSuperclass();
            }
        }
        return null;
    }

    private static Object allocateInstance(Class<?> type) {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");

            try {
                theUnsafe.setAccessible(true);
            } catch (Exception ignored) {
            }

            Object unsafe = theUnsafe.get(null);
            Method allocate = unsafeClass.getMethod("allocateInstance", Class.class);
            return allocate.invoke(unsafe, type);
        } catch (Throwable ignored) {
            return null;
        }
    }
}
