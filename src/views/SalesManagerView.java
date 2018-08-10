package views;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class SalesManagerView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		SalesManagerView frame = new SalesManagerView();
		frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public SalesManagerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1184, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(45, 36, 150, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("~");
		label.setBounds(207, 45, 17, 15);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 36, 150, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton search_button = new JButton("\uAC80\uC0C9");//�˻�
		search_button.setBounds(408, 28, 109, 43);
		panel.add(search_button);
		
		JButton week_sales_button = new JButton("\uC8FC\uAC04\uB9E4\uCD9C");//�ְ�����
		week_sales_button.setBounds(636, 28, 109, 43);
		panel.add(week_sales_button);
		
		JButton month_sales_button = new JButton("\uC6D4\uB9E4\uCD9C");//������
		month_sales_button.setBounds(802, 28, 109, 43);
		panel.add(month_sales_button);
		
		JButton year_sales_button = new JButton("\uC5F0\uB9E4\uCD9C");//������
		year_sales_button.setBounds(960, 28, 109, 43);
		panel.add(year_sales_button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 689, 1184, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton close_button = new JButton("\uB2EB\uAE30");
		close_button.setBounds(1002, 10, 109, 43);
		panel_1.add(close_button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 89, 1184, 601);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JList list = new JList();
		list.setBounds(12, 10, 462, 561);
		panel_2.add(list);
		
		ChartPanel chart = new ChartPanel(getChart());
		chart.setBounds(500, 10, 672, 561);
		panel_2.add(chart);
	}
	
	public JFreeChart getChart() {
		
		// ������ ����
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1
        DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();                // line chart 1

        // ������ �Է� ( ��, ����, ī�װ� )
        // �׷��� 1       
        dataset1.addValue(1.0, "S1", "1��");
        dataset1.addValue(4.0, "S1", "2��");
        dataset1.addValue(3.0, "S1", "3��");
        dataset1.addValue(5.0, "S1", "4��");
        dataset1.addValue(5.0, "S1", "5��");
        dataset1.addValue(7.0, "S1", "6��");
        dataset1.addValue(7.0, "S1", "7��");
        dataset1.addValue(8.0, "S1", "8��");
        dataset1.addValue(2.0, "S1", "9��");
        dataset1.addValue(5.1, "S1", "10��");
        dataset1.addValue(2.3, "S1", "11��");
        dataset1.addValue(3.2, "S1", "12��");

//        // �׷��� 2       
//        dataset12.addValue(0, "S2", "1��");
//        dataset12.addValue(0, "S2", "2��");
//        dataset12.addValue(0, "S2", "3��");
//        dataset12.addValue(0, "S2", "4��");
//        dataset12.addValue(0, "S2", "5��");
//        dataset12.addValue(0, "S2", "6��");
//        dataset12.addValue(0, "S2", "7��");
//        dataset12.addValue(0, "S2", "8��");
//        dataset12.addValue(6.0, "S2", "9��");
//        dataset12.addValue(0, "S2", "10��");
//        dataset12.addValue(0, "S2", "11��");
//        dataset12.addValue(0, "S2", "12��");

        // �׷��� 3       
        dataset2.addValue(9.0, "T1", "1��");
        dataset2.addValue(7.0, "T1", "2��");
        dataset2.addValue(2.0, "T1", "3��");
        dataset2.addValue(6.0, "T1", "4��");
        dataset2.addValue(6.0, "T1", "5��");
        dataset2.addValue(9.0, "T1", "6��");
        dataset2.addValue(5.0, "T1", "7��");
        dataset2.addValue(4.0, "T1", "8��");
        dataset2.addValue(8.0, "T1", "9��");
        dataset2.addValue(8.0, "T1", "10��");
        dataset2.addValue(8.0, "T1", "11��");
        dataset2.addValue(8.0, "T1", "12��");

        // ������ ���� �� ����
        // ������ ����
        final BarRenderer renderer = new BarRenderer();
        final BarRenderer renderer12 = new BarRenderer();
        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();

        // ���� �ɼ� ����
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER
            );
        final ItemLabelPosition p_below = new ItemLabelPosition(
                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
                     );
        Font f = new Font("Gulim", Font.BOLD, 14);
        Font axisF = new Font("Gulim", Font.PLAIN, 14);

        // ������ ����
        // �׷��� 1
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(p_center);
        renderer.setBaseItemLabelFont(f);

        renderer.setSeriesPaint(0, new Color(112,173,232));//�ٻ�

        // �׷��� 2       
        renderer12.setSeriesPaint(0, new Color(232,168,255));
        renderer12.setBaseItemLabelFont(f);
        renderer12.setBasePositiveItemLabelPosition(p_center);
        renderer12.setBaseItemLabelGenerator(generator);
        renderer12.setBaseItemLabelsVisible(true);

        // �׷��� 3       
        renderer2.setBaseItemLabelGenerator(generator);
        renderer2.setBaseItemLabelsVisible(true);
        renderer2.setBaseShapesVisible(true);
        renderer2.setDrawOutlines(true);
        renderer2.setUseFillPaint(true);
        renderer2.setBaseFillPaint(Color.WHITE);
        renderer2.setBaseItemLabelFont(f);
        renderer2.setBasePositiveItemLabelPosition(p_below);
        renderer2.setSeriesPaint(0,new Color(219,121,22));
        renderer2.setSeriesStroke(0,new BasicStroke(
                                               2.0f,
                                               BasicStroke.CAP_ROUND,
                                               BasicStroke.JOIN_ROUND,
                                               3.0f)
        );

        // plot ����
        final CategoryPlot plot = new CategoryPlot();

        // plot �� ������ ����
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
        plot.setDataset(1,dataset12);
        plot.setRenderer(1,renderer12);
        plot.setDataset(2, dataset2);
        plot.setRenderer(2, renderer2);

        // plot �⺻ ����
        plot.setOrientation(PlotOrientation.VERTICAL);             // �׷��� ǥ�� ����
        plot.setRangeGridlinesVisible(true);                       // X�� ���̵� ���� ǥ�ÿ���
        plot.setDomainGridlinesVisible(true);                      // Y�� ���̵� ���� ǥ�ÿ���

        // ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        // X�� ����
        plot.setDomainAxis(new CategoryAxis());              // X�� ���� ����
        plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // ī�װ� �� ��ġ ����

        // Y�� ����
        plot.setRangeAxis(new NumberAxis());                 // Y�� ���� ����
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y�� ���ݶ� ��Ʈ ����

        // ���õ� plot�� �������� chart ����
        final JFreeChart chart = new JFreeChart(plot);
        return chart;
    }
}
