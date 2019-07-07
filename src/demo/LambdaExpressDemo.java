package demo;

@FunctionalInterface
interface Foo
{
    public int add(int x, int y);

    default int div(int x, int y)
    {
        System.out.println("*****hello java0222");
        return x/y;
    }

    public static int mv(int x, int y)
    {
        return x * y;
    }
}

/**
 * 2    Lambda Express
 *  2.1 口诀：
 *      拷贝小括号，写死右箭头，落地大括号
 *
 *  2.2 @FunctionalInterface
 *
 *  2.3 default
 *
 *  2.4 静态方法实现
 */
public class LambdaExpressDemo
{
    public static void main(String[] args)
    {
        /*Foo foo = new Foo()
        {
            @Override
            public void sayHello()
            {
                System.out.println("*****hello java0222");
            }
        };
        foo.sayHello();*/

        Foo foo = (x ,y) -> {
            System.out.println("****come in here");
            return x + y;
        };
        System.out.println(foo.add(3, 5));

        System.out.println(foo.div(10, 5));

        System.out.println(Foo.mv(3, 5));
    }
}
