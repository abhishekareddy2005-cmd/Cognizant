public class FactoryMethodTest {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.createDocument().open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.createDocument().open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.createDocument().open();
    }
}
