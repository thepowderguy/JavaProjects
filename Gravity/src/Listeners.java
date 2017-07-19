import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public class Listeners implements MouseListener, MouseWheelListener, KeyListener, MouseMotionListener {
	
	Gravity parent;
	public Listeners(Gravity instance)
	{
		parent = instance;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		//if (event.getKeyCode() == KeyEvent.vk_)
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		if (event.getWheelRotation() < 0)
			parent.zoom *= 1.2;
		if (event.getWheelRotation() > 0)
			parent.zoom /= 1.2;
	}

	@Override
	public void mouseClicked(MouseEvent event) {}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1) {
			parent.mouseoriginx = event.getX();
			parent.mouseoriginy = event.getY();
		} else if (event.getButton() == MouseEvent.BUTTON3) {
			parent.dragging = true;
			parent.dragstartx = event.getX();
			parent.dragstarty = event.getY();
			parent.tempcenterx = parent.centerx;
			parent.tempcentery = parent.centery;
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1) {
			parent.bodies.add(new Planet((parent.mouseoriginx-SimulationDisplay.width/2)/parent.zoom+parent.centerx,
					(parent.mouseoriginy-SimulationDisplay.height/2)/parent.zoom+parent.centery,
					(event.getX()-parent.mouseoriginx)/100.0/parent.zoom,
					(event.getY()-parent.mouseoriginy)/100.0/parent.zoom,
					0.5));
			parent.bodies.get(parent.bodies.size()-1).setName("PLANET-"+String.format("%04d", parent.PlanetID));
			parent.PlanetID++;
		} else if (event.getButton() == MouseEvent.BUTTON3) {
			parent.dragging = false;
			parent.tempcenterx = parent.centerx;
			parent.tempcentery = parent.centery;
		}
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		if (parent.dragging)
		{
			parent.centerx = parent.tempcenterx - (event.getX() - parent.dragstartx)/parent.zoom;
			parent.centery = parent.tempcentery - (event.getY() - parent.dragstarty)/parent.zoom;
		}
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
