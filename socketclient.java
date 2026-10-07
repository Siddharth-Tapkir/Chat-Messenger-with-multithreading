import java.io.*;
import java.net.*;
class SocketClientReader extends Thread
{
    private Socket sobj;

    public SocketClientReader(Socket obj)
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

            String str = null;

            while(true)
            {
                str = input.readLine();

                System.out.println("Server says : "+str);
                if(str == null || str.equals("bye"))
                {
                    break;
                }
            }
        }
        catch(Exception e)
        {}
    }
}
class SocketClientWriter extends Thread
{
    private Socket sobj;

    public SocketClientWriter(Socket obj)
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
            PrintStream pobj = new PrintStream(sobj.getOutputStream());
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
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
class socketclient 
{
    public static void main(String A[])throws Exception
    {
        Socket sobj = new Socket("localhost",5111);

        System.out.println("Connection succesfull");

        SocketClientReader obj1 = new SocketClientReader(sobj);
        
        SocketClientWriter obj2 = new SocketClientWriter(sobj);

        obj1.start();
        obj2.start();

        
        obj1.join();
        obj2.join();
    }
}
