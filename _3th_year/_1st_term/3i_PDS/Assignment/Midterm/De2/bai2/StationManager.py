from Assignment.Midterm.De2.bai2.Station import Station


def read_station_fromfile(station_file):
    # station_file is csv file
    # line 0: name, idx, lon, lat
    # line 1: station 1, ...
    # line 2: station 2, ...
    # ...
    # line n: station n, ...
    station_list = []
    file = open(station_file, "rt", encoding="utf-8")

    head = file.readline()
    # skip the first line
    for line in file:
        tks = line.strip().split(",")
        name, idx, lon, lat = tks[0], tks[1], float(tks[2]), float(tks[3])
        s = Station(name, idx, lat, lon)
        station_list.append(s)

    file.close()

    return station_list


def read_rain_from_file(rain_file, station_list):
    # rain_file is csv file
    # line 0: time, station 1, station 2, ..., station n
    # line 1: date 1, rain of station 1, rain of station 2, ..., rain of station n
    # line 2: date 2, rain of station 1, rain of station 2, ..., rain of station n
    # ...
    # line n: date n, rain of station 1, rain of station 2, ..., rain of station n
    file = open(rain_file, "rt", encoding="utf-8")

    head = file.readline()
    stations = head.strip().split(",")[1:]
    rain_dict_list = [dict() for s in stations]
    for line in file:
        tks = line.strip().split(",")
        date = tks[0]
        for i in range(len(rain_dict_list)):
            rain_dict_list[i][date] = float(tks[i + 1])

    for s in station_list:
        for i in range(len(stations)):
            if s.name == stations[i]:
                s.set_rain_infor(rain_dict_list[i])
                # only have one station have the same name
                break

    file.close()


def count_dry_day(s):
    return sum([1 for r in s.rain.value() if r == 0])


def get_stations_dry_frequent(station_list):
    max_fre = max([count_dry_day(s) for s in station_list])

    result = []
    for s in station_list:
        if count_dry_day(s) == max_fre:
            result.append(s.name)
    result.sort()

    return result

def find_stations_rain_above_avg(station_list):
    total = sum([sum(s.rain.values()) for s in station_list])
    avg = total / len(station_list)

    result = [s.name for s in station_list if sum(s.rain.values()) > avg]
    result.sort()

    return result

def find_top_k_rain(date, station_list, k=5):
    pass

def find_lowest_rain_station(station_list):
    pass
