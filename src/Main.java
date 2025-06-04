import com.pstag.test.component.CommandLine;
import com.pstag.test.model.Car;
import com.pstag.test.parser.FileParserFactory;
import com.pstag.test.utils.FilterUtil;
import com.pstag.test.utils.OutputFormatter;
import com.pstag.test.utils.OutputFormatterFactory;
import com.pstag.test.utils.SortUtil;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CommandLine cli = new CommandLine(args);
        try {
            List<Car> cars = FileParserFactory.getParser(cli.getInputFile()).parse(cli.getInputFile());

            if (cli.hasFilters()) {
                cars = FilterUtil.applyFilters(cars, cli.getFilters());
            }

            if (cli.getSortOption() != null) {
                cars = SortUtil.sort(cars, cli.getSortOption());
            }

            OutputFormatter formatter = OutputFormatterFactory.getFormatter(cli.getOutputFormat());
            formatter.format(cars);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}