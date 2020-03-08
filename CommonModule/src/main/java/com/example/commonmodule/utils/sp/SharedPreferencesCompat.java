package com.example.commonmodule.utils.sp;

import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
 *
 * @author zhy
 *
 */
public  class SharedPreferencesCompat {

    private static final Method sApplyMethod = findApplyMethod();

    /**
     * 反射查找apply的方法
     *
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Method findApplyMethod()
    {
        try
        {
            Class clz = SharedPreferences.Editor.class;
            return clz.getMethod("apply");
        } catch (NoSuchMethodException e)
        {
        }

        return null;
    }

    /**
     * 如果找到则使用apply执行，否则使用commit
     *
     * @param editor
     */
    public static void apply(SharedPreferences.Editor editor)
    {
        try
        {
            if (sApplyMethod != null)
            {
                sApplyMethod.invoke(editor);
                return;
            }
        } catch (IllegalArgumentException e)
        {
        } catch (IllegalAccessException e)
        {
        } catch (InvocationTargetException e)
        {
        }
        editor.commit();
    }
}