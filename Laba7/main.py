from web import web

url = input('Insert URL: ')
depth = input('Insert depth of search: ')

web = web(url, depth)

web.scan()

