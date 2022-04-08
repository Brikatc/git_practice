import psycopg2

conn=psycopg2.connect(database="sbx_test", user='postgres', password='bkc!12278895', host='localhost',
port='5432')

cursor=conn.cursor()
cursor.execute("select version()")

data=cursor.fetchone()
print("Connection established to: ",data)

conn.close()
