package spark;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by StevenZhu on 16/10/12.
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface HiveTablePartition {
}
