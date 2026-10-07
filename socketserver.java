import java.io.*;
import java.net.*;

class SocketServerReader extends Thread
{
    private Socket sobj;
    public SocketServerReader(Socket obj)throws Exception
    {
       this.sobj = obj;
    }
    
    public void run()
    {
        if(this.sobj == null)
        {
            return;
        }
        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

            String str = "null";

            while(true)
            {
                if(str == null || str.equals("bye"))
                {
                    break;
                }
                str = input.readLine();
                System.out.println("client says : "+str);
            }
            str = null;
        }
        catch(Exception e)
        {}
    }
}

class SocketServerWriter extends Thread
{
    private Socket sobj;

    public SocketServerWriter(Socket obj)throws Exception
    {
       this.sobj = obj;
    }
    
    public void run()
    {
        if(this.sobj == null)
        {
            return;
        }
        try
        {
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintStream pobj = new PrintStream(sobj.getOutputStream());

            String str = null;

            while(true)
            {
                str = keyboard.readLine();
                pobj.println(str);
                if(str.equals("bye") || str == null)
                {
                    break;
                }
            }
            keyboard.close();
            pobj.close();
        }
        catch(Exception e)
        {}
    }
}
class socketserverMain
{
    public static void main(String A[])throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5111);

        Socket sobj = ssobj.accept();

        System.out.println("Connection successfull");

        SocketServerReader obj1 = new SocketServerReader(sobj);

        SocketServerWriter obj2 = new SocketServerWriter(sobj);

        obj1.start();
        obj2.start();

    }
}