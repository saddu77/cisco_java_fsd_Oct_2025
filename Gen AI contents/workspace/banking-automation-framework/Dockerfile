FROM python:3.11-slim

WORKDIR /automation

RUN apt-get update && apt-get install -y \
    wget unzip chromium chromium-driver

COPY requirements.txt .
RUN pip install -r requirements.txt

COPY . .

CMD ["pytest", "--html=reports/report.html", "--self-contained-html"]
