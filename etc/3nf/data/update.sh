#!/bin/sh

export COLUMN="xing linked_in stackoverflow github whatsapp wordpress spotify snapchat skype slack slideshare"
export COLUMN="$COLUMN pinterest paypal meetup lastfm imdb foursquare digg delicious url500px amazon hacker_news scribd"
export COLUMN="$COLUMN tumblr viadeo yahoo yoast yelp"

export COLUMN_VALUE=" NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,"
export COLUMN_VALUE="$COLUMN_VALUE NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,"
export COLUMN_VALUE="$COLUMN_VALUE NULL, NULL, NULL, NULL, NULL, "

export FILES=`ls | grep .sql`

for i in $FILES
do
    echo $i

    #for k in $COLUMN
    #do
    #    echo " $k,"
    #    cat $i | sed "s/ $k,//g" > $i.txt
    #    mv $i.txt $i
    #done
    cat $i | sed "s/$COLUMN_VALUE//" > $i.txt
    mv $i.txt $i
    #cat $i | sed "s/, ,/,/" > $i.txt
    #mv $i.txt $i
done