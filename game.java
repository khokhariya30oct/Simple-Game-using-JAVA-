import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;

/*
<applet code="game" width=1366 height=650>
</applet>
*/
public class game extends Applet implements Runnable,KeyListener{
	Thread t;
	int x,y,g1,j1,point=0,x1,y1,leftarrow;
	Color c1,c2;
	char d;
	String msg="";
			public void init()
			{
			addKeyListener(this);
			requestFocus();
			}
			
			public void start()
			{
			t=new Thread(this);
			t.start();
			}
	
			public void run()
			{
			    try
				{
					for(int i=1;i<600;i++)
					{
					x=600;
					y=i;
						if(i==599)
						{
							
							if(d=='a' || d=='d')
							{
								i=0;
								Random r1=new Random();
								g1=r1.nextInt(1000);
								d='z';
							}
							else
							{
								showStatus("your Score    "+point+"       points");
								Thread.currentThread().suspend();
								
							}
						}
							if(point>=0 && point<=10)
							{
							Thread.sleep(5);
							}
							else if(point>=11 && point<=20)
							{
							Thread.sleep(4);
							}
							else if(point>=21 && point<=30)
							{
							Thread.sleep(3);
							}
							else if(point>=31 && point<=50)
							{
							Thread.sleep(2);
							}
							else
							{
							Thread.sleep(1);
							}
						repaint();
					}
				}catch(Exception e){}
			}
				
			public void keyTyped(KeyEvent ke)
			{
				
			}
		
		
			public void keyReleased(KeyEvent ke)
			{	
			}
			public void keyPressed(KeyEvent ke)
			{
				d=ke.getKeyChar();
				leftarrow=0;
				if(d=='a')
				{
					x=300;
					y=300;
					if(j1==601){
					point++;
					}
					  //repaint();
					else	
					{
						showStatus("your Score      "+point+"       points");
						x1=300;
						y1=300;
						Thread.currentThread().suspend();
					}
				repaint();
				}
						
				else if(d=='d')
				{
					leftarrow=1;
					x=1000;
					y=300;
							
					if(j1==599){
						point++;
					}
			
					else{
						showStatus("your Score         "+point+"       points");
						x1=1000;
						y1=300;
						Thread.currentThread().suspend();
						
						}
				repaint();
				}
				
				else{}
			}	
	
	public void paint(Graphics g)
	{
	
		g.setColor(Color.green);
		g.drawLine(500,10,500,700);
		g.drawLine(900,10,900,700);
		g.fillRect(1000,300,100,100);   //right Sided object
		g.setColor(Color.red);
		g.fillOval(300,300,100,100);   //left sided object 
			if(g1%2==0)
			{
			c1=new Color(255,0,0);
			g.setColor(c1);
			g.fillOval(x,y,100,100);
			j1=x+1;
			}
			else
			{
			c2=new Color(0,255,0);
			g.setColor(c2);
			g.fillRect(x,y,100,100);
			j1=x-1;
			}
			if(j1==601)
				{
				g.drawLine(x1,y1,x1-50,y1);
				}
			else
				{
				g.drawLine(x1,y1,x1+50,y1);
				}
			g.drawString(msg+point,50,50);
			if(leftarrow==0)
			{
				g.drawLine(300,200,300,150);
				g.drawLine(300,201,300,151);
			}
			else if(leftarrow==1)
			{
				g.drawLine(1000,200,1000,150);
				g.drawLine(1000,201,1000,151);
			
			}
			else
			{}
	}		
}
