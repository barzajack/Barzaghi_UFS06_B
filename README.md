# Barzaghi_UFS06_B

Un server HTTP ha una lista di vini che puo' inviare
al client che invii i seguenti possibile comandi TESTUALI:

- "/?cmd=red"
- "/?cmd=white"
- "/?cmd=sorted_by_name"
- "/?cmd=sorted_by_price"

I comandi saranno in get via curl -> curl "http://172.16.151.9:8000/?cmd=all"

Si scrivano le opportune classi/array JAVA a supporto (classe
Wine) i cui attributi si ricavano dal seguente JSON...
