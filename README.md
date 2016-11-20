# eveapi
Scala bindings for various APIs related to Eve Online

## data
Contains all the case classes that describe the incoming raw data.

## compressed
Contains compressed case classes, mainly without the hrefs. Also contains
information to regenerate the hrefs.

## xml
Contains everything related to the old XML API.

## blaze-client
Contains the code to interact with the case classes.

## Yolo

Lets you play around with the API.

    val oauth2 = Yolo.oauth2(Uri.uri(...), id, secret, scope)
    val yolo = Yolo.genToken(oauth2).unsafePerformSync // and ignore the errors

    yolo.run(Lift.get(uri.Skills))

Somehow

    Lift.get(GetLinkI[Uri, Fleet[Uri]](Uri.uri("https://crest-tq.eveonline.com/fleets/1022511257640/")))

freezes up the repl while it's trying to generate the decoder. Maybe nail the
codecs via `@JsonCodec` or similar.
