package com.ding.webcollector_boot.clawer;

public class DazhongCrawler  {

/*    AtomicInteger id = new AtomicInteger(0);

    *//**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     *//*
    public DazhongCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        *//*start page*//*
        this.addSeed("http://www.dianping.com/");

        *//*fetch url like http://www.dianping.com/xxxxxxx*//*
        this.addRegex("http://www.dianping.com/.*");

        *//*do not fetch jpg|png|gif*//*
        this.addRegex("-.*\\.(jpg|png|gif).*");
        *//*do not fetch url contains #*//*
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums nextLinks) {
        try {
            *//*保存网页到download文件夹中*//*
            FileUtils.writeFileWithParent("download/" + id.incrementAndGet() + ".html", page.getContent());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    *//**
     * 爬取页面中的代理信息，将代理信息放入随机代理生成器中
     * 为了演示2.06版本引入的HttpRequest,这里抓取代理的过程用HttpRequest完成
     * 实际应用中，我们建议使用BreadthCrawler来完成对代理的抓取
     *
     * @param url 包含代理信息的页面
     * @param proxyGenerator 随机代理生成器
     * @throws Exception
     *//*
    public static void addProxy(String url, RandomProxyGenerator proxyGenerator) throws Exception {
        *//*HttpRequest是2.07版的新特性*//*
        HttpRequest request = new HttpRequest(url);
        *//*重试3次*//*
        for (int i = 0; i <= 3; i++) {
            try {
                String html = request.getResponse().getHtmlByCharsetDetect();
                String regex = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}).+?([0-9]{1,4})";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    System.out.println("add proxy:" + matcher.group(1) + ":" + matcher.group(2));
                    String ip = matcher.group(1);
                    int port = Integer.valueOf(matcher.group(2));
                    proxyGenerator.addProxy(ip, port);
                }
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        DazhongCrawler crawler = new DazhongCrawler("crawl_dazhong", true);

        crawler.setThreads(50);
        crawler.setTopN(100);

        *//*使用代理时，爬虫各种等待时间需要加长，否则容易出现超时*//*
        *//*连接超时*//*
        Config.TIMEOUT_CONNECT = 5000;
        *//*读取超时*//*
        Config.TIMEOUT_READ = 20000;
        *//*在整个爬取过程中，包括断点续爬，同一个URL如果爬取超过MAX_RETRY次爬取失败，则放弃这个URL
         使用多代理爬取时，失败概率增加，所以需要将MAX_RETRY设置为一个较大的值*//*
        *//*注意，如果某个URL在某层中爬取失败，不要担心，这个URL会在后面的层中继续被爬取，
           直到爬取失败次数达到MAX_RETRY*//*
        Config.MAX_RETRY = 30;
        *//*爬取线程池如果超过requestMaxInterval的时间没有发送http请求，则强制停止线程池*//*
        Config.requestMaxInterval = 1000 * 60 * 2;

        *//*随机代理生成器,RandomProxyGenerator是WebCollector代理切换的一个插件*//*
        *//*用户可以根据自己的业务需求，定制代理切换的插件，代理切换插件需要实现ProxyGenerator*//*
        RandomProxyGenerator proxyGenerator = new RandomProxyGenerator() {

            *//*每当用一个代理爬取成功，会触发markGood方法*//*
            @Override
            public void markGood(Proxy proxy, String url) {
                InetSocketAddress address = (InetSocketAddress) proxy.address();
                System.out.println("Good Proxy:" + address.toString() + "   " + url);
            }

            *//*每当用一个代理爬取失败，会触发markBad方法*//*
            @Override
            public void markBad(Proxy proxy, String url) {
                InetSocketAddress address = (InetSocketAddress) proxy.address();
                System.out.println("Bad Proxy:" + address.toString() + "   " + url);

                *//*可以利用markGood或者markBad给出的反馈，来调整随机代理生成器中的代理*//*
                *//*可以动态添加或删除代理，这些操作都是线程安全的*//*
                //removeProxy(proxy);
                
                *//*随机代理RandomProxyGenerator是一种比较差的策略，
                  我们建议用户自己编写符合自己业务的ProxyGenerator。
                  编写ProxyGenerator主要实现ProxyGenerator中的next方法。*//*
            }

        };

        for (int i = 1; i <= 5; i++) {
            *//*从这些页面中爬取代理信息，加入proxyGenerator*//*
            addProxy("http://proxy.com.ru/list_" + i + ".html", proxyGenerator);
        }

        *//*获取爬虫的http请求器*//*
        HttpRequesterImpl requester = (HttpRequesterImpl) crawler.getHttpRequester();
        *//*设置http请求器的随机代理请求器*//*
        requester.setProxyGenerator(proxyGenerator);
 

        //crawler.setResumable(true);
         *//*start crawl with depth of 4*//*
        crawler.start(30);

    }*/

}