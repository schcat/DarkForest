import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleButton extends JButton {
Shape shape;
Color bgColor = SystemColor.control;

public CircleButton() {
    this(null);
}

public CircleButton(String label) {
    this(label, null);
}

public CircleButton(String label, Color bgColor) {
    super(label); // 调用父类构造方法
    if (bgColor != null) {
      this.bgColor = bgColor;
    }
    Dimension size = this.getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    this.setPreferredSize(size); // 设置宽高等距
    this.setContentAreaFilled(false); // 不绘制内容区域
    this.setBorderPainted(false); // 不绘制边框
    this.setFocusPainted(false); // 不绘制焦点状态
}

protected void paintComponent(Graphics g) {
    // 如果鼠标按下，isArmed()方法返回true
    if (this.getModel().isArmed()) {
      g.setColor(java.awt.SystemColor.controlHighlight);
    } else {
      g.setColor(java.awt.SystemColor.controlShadow);
      g.setColor(this.bgColor); // 设置背景颜色
    }
    g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // 绘制圆形背景区域
    g.setColor(java.awt.SystemColor.controlShadow); // 设置边框颜色
    g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // 绘制边框线
    super.paintComponent(g);
}

public boolean contains(int x, int y) {
    if ((shape == null) || (!shape.getBounds().equals(this.getBounds()))) {
      this.shape = new Ellipse2D.Float(0, 0, this.getWidth(), this
          .getHeight());
    }
    return shape.contains(x, y);
}
}

class CircleButtonTest {

public static void main(String[] args) {
    JFrame jf = new JFrame("自定义按钮");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(350, 280);
    jf.setLocationRelativeTo(null);
    jf.setLayout(new FlowLayout());
    Color arrColor[] = new Color[] { Color.blue, Color.black, Color.red,
        Color.yellow, Color.green };
    for (int i = 0; i < 5; i++) {
      CircleButton cb = new CircleButton("圆形按钮" + (i+1),arrColor[i]);
      jf.getContentPane().add(cb);
      cb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("按钮");
        }
      });
    }
    jf.setVisible(true);
}
}
