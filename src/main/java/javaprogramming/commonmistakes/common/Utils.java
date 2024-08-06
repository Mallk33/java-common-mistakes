package javaprogramming.commonmistakes.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class Utils {

    /**
     * 加载指定类路径下的属性文件，并将属性设置为系统属性，同时在日志中输出每个属性的键值对。
     *
     * @param clazz    类，用于定位属性文件的类路径。
     * @param fileName 属性文件的名称。
     */
    public static void loadPropertySource(Class clazz, String fileName) {
        try {
            Properties p = new Properties();
            // 加载指定类路径下的属性文件
            p.load(clazz.getResourceAsStream(fileName));
            p.forEach((k, v) -> {
                log.info("{}={}", k, v);
                System.setProperty(k.toString(), v.toString());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
