package salesManager;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

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

public class makeGraph {

	public JFreeChart getChart(/*int[] arr,String[] category*/) {
		
		// ������ ����
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1
//        DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2 
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();                // line chart 1

        // ������ �Է� ( ��, ����, ī�װ� )
        // �׷��� 1
//        for(int i=0;i<arr.length;i++)
//        {
//        	dataset1.addValue(arr[i], "snack",category[i]);
//        }
        
        
        dataset1.addValue(1.0, "snack", "1��");
        dataset1.addValue(4.0, "snack", "2��");
        dataset1.addValue(3.0, "snack", "3��");
        dataset1.addValue(5.0, "snack", "4��");
        dataset1.addValue(5.0, "snack", "5��");
        dataset1.addValue(7.0, "snack", "6��");
        dataset1.addValue(7.0, "snack", "7��");
        dataset1.addValue(8.0, "snack", "8��");
        dataset1.addValue(2.0, "snack", "9��");
        dataset1.addValue(5.1, "snack", "10��");
        dataset1.addValue(2.3, "snack", "11��");
        dataset1.addValue(3.2, "snack", "12��");

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

        
        
//        for(int i=0;i<arr.length;i++)
//        {
//        	dataset2.addValue(arr[i], "totalSales",category[i]);
//        }
        
        
        // �׷��� 3       
        dataset2.addValue(9.0, "totalSales", "1��");
        dataset2.addValue(7.0, "totalSales", "2��");
        dataset2.addValue(2.0, "totalSales", "3��");
        dataset2.addValue(6.0, "totalSales", "4��");
        dataset2.addValue(6.0, "totalSales", "5��");
        dataset2.addValue(9.0, "totalSales", "6��");
        dataset2.addValue(5.0, "totalSales", "7��");
        dataset2.addValue(4.0, "totalSales", "8��");
        dataset2.addValue(8.0, "totalSales", "9��");
        dataset2.addValue(8.0, "totalSales", "10��");
        dataset2.addValue(8.0, "totalSales", "11��");
        dataset2.addValue(8.0, "totalSales", "12��");

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
//        renderer12.setSeriesPaint(0, new Color(232,168,255));
//        renderer12.setBaseItemLabelFont(f);
//        renderer12.setBasePositiveItemLabelPosition(p_center);
//        renderer12.setBaseItemLabelGenerator(generator);
//        renderer12.setBaseItemLabelsVisible(true);

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
//        plot.setDataset(1,dataset12);
//        plot.setRenderer(1,renderer12);
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
