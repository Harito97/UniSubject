import scrapy


class ImagesSpiderSpider(scrapy.Spider):
    name = "images_spider"
    allowed_domains = ["oralcancerfoundation.org"]
    start_urls = ["https://oralcancerfoundation.org/dental/oral-cancer-images"]

    def parse(self, response):
        pass
