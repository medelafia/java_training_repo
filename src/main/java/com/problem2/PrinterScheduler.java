package com.problem2;


import java.util.List;

public class PrinterScheduler {

    private List<Printer> printers;
    private List<PrintJob> printJobs ;

    public PrinterScheduler(List<Printer> printers, List<PrintJob> printJobs) {
        this.printers = printers;
        this.printJobs = printJobs;
    }
    
    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }

    public List<PrintJob> getPrintJobs() {
        return printJobs;
    }

    public void setPrintJobs(List<PrintJob> printJobs) {
        this.printJobs = printJobs;
    }
}
