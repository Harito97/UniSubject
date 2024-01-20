class Station:
    def __init__(self, name, sid, lat, lon):
        self.name = name 
        self.sid = sid
        self.lat = lat
        self.lon = lon
        self.rain = dict()

    def set_rain_infor(self, rain_dict):
        self.rain = rain_dict

    def __str__(self):
        return ''
    
    def get_distance(self, station):
        import math
        return math.sqrt((self.lat - station.lat) ** 2 + (self.lon - station.lon) ** 2)
    
    def get_rain_value(self, date):
        return self.rain.get(date, 0)
