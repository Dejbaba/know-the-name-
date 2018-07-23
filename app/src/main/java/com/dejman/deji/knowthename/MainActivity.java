package com.dejman.deji.knowthename;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity {

        private InterstitialAd mInterstitialAd;






    private String TAG = "OrientationDemo";
   List<Integer> list = new ArrayList<>();
   List<Integer> options = new ArrayList<>();





    int highest = 0;
    String savedscore;
    String ansText;
    int correct = 0;
    ProgressBar pb;
    pbClass i;
    TextView tv;
    TextView points;
    TextView newS;
    TextView bestS;
    Button btn0, btn1, btn2;
    //Button btNext;
    Button replay;
    Button MainMenu;
    MediaPlayer soundH, soundC, soundW;
    SoundPool sp;
    int soundId, soundId2;
    ToggleButton change;
    RelativeLayout r;
    AlertDialog dialog;
    int flag;
    int k;
    int a, b, c;











    String[] Questions = {
            "MUHAMMADU BUHARI?",            //0
            "BARACK OBAMA?",                        //1
            "VLADIMIR PUTIN?",                        //2
            "STEVE JOBS?",                          //3
            "MARK ZUCKERBERG?",                     //4
            "SIR FREDERICK LORD LUGARD?",            //5
            "Wii?",  //6
            "PLAYSTATION?", //7
            "J.K.ROWLING?", //8
            "RICHARD QUEST?", //9
            "LIONEL MESSI?", //10
            "CRISTIANO RONALDO?", //11
            "NOVAK DJOKOVIC?", //12
            "serena williams?", //13
            "Bill Gates?", //14
            "Burj khalifa?", //15
            "Christiane Amanpour?", //16
            "CNN?", //17
            "Sepp Blatter?", //18
            "michael jackson?", //19
            "Etisalat?", //20
            "The Pentagon?", //21
            "The kremlin?", //22
            "Buckingham Palace?", //23
            "The white house?", //24
            "Henry ford?", //25
            "Colosseum?", //26
            "Air force one?", //27
            "Adolf Hitler?", //28
            "Nelson Mandela?", //29
            "madrid?", //30
            "Ducati?", //31
            "Zurich?", //32
            "Statue of liberty?", //33
            "Golden gate bridge?", //34
            "Silicon Valley?", //35
            "Tim Cook?", //36
            "ios?", //37
            "Aliko Dangote?", //38
            "satya nadella?", //39
            "Dubai?", //40
            "Palm Jumeirah?", //41
            "Lawrence Page?", //42
            "Qatar?", //43
            "Maldives?", //44
            "Tesla?", //45
            "Mark Cuban?", //46
            "NASA?", //47
            "Instagram?", //48
            "Great Wall?", //49
            "VolksWagen?", //50
            "Casablanca?", //51
            "Ferrari?", //52
            "Chrome?", //53
            "Reed Hastings?", //54
            "River Thames?", //55
            "Mount Everest?", //56
            "Mount Kilimanjaro?", //57
            "NATO?", //58
            "Air Jordan?", //59
            "NIKE?", //60
            "Charles Dickens?", //61
            "Arthur Conan Doyle?", //62
            "The Nutty Professor?", //63
            "Lewis Hamilton?", //64
            "Tiger Woods?", //65
            "Michael Jordan?", //66
            "Abraham Lincoln?", //67
            "Azerbaijan?", //68
            "Usain bolt?", //69
            "DSTV?", //70
            "leonardo dicaprio?", //71
            "sahara desert?", //72
            "Burj Al Arab?", //73
            "JW Marriott Marquis?", //74
            "Tokyo?", //75
            "cairo?", //76
            "WHO?", //77
            "Geneva?", //78
            "unicef?", //79
            "The Wright Brothers?", //80
            "Lake Tanganyika?", //81
            "Samsung?", //82
            "Gps?", //83
            "Adidas?", //84
            "ASAP?", //85
            "xoxo?", //86
            "lol?", //87
            "Android?", //88
            "Toyota?", //89
            "Rolls-Royce?", //90
            "BMW?", //91
            "chanel?", //92
            "thriller?", //93
            "fbi?", //94
            "Kim Jong-un?", //95
            "Qingdao Haiwan?", //96
            "DANYANG KUNSHAN GRAND BRIDGE?", //97
            "Warren Buffett?", //98
            "Carlos Slim?", //99
            "barclays?", //100
            "Darth Vader?", //101
            "Nascar?", //102
            "São Paulo?", //103
            "cctv?", //104
            "Xbox?", //105
            "Stan Lee?", //106
            "LeBron James?", //107
            "Gianni infantino?", //108
            "Kobe Bryant?", //109
            "Richard Branson?", //110
            "Accra?", //111
            "Abuja?", //112
            "Panama?", //113
            "Ibiza?", //114
            "Bugatti?", //115
            "Givenchy?", //116
            "Beyoncé?", //117
            "Alaska?", //118
            "Eiffel Tower?", //119
            "Venice?", //120
            "innoson?", //121
            "Wardell Stephen Curry II?", //122
            "Daniel Pedrosa Ramal?", //123
            "Andrew Barron Murray?", //124
            "David Cameron?", //125
            "Audi?", //126
            "Floyd Mayweather?", //127
            "6th October Bridge?", //128
            "Robert Mugabe?", //129
            "Augustine Azuka Okocha?", //130
            "warsaw?", //131
            "Muhammad Ali?", //132
            "Mahatma Mohandas Gandhi?", //133
            "Fendi?", //134
            "Philipp Patrick Plein?", //135
            "Mississippi?", //136
            "Tony Hawk?", //137
            "Josè Mourinho?", //138
            "josep Guardiola?", //139
            "Princess Diana?", //140
            "Mario Gianluigi Puzo?", //141
            "Kevin Wayne durant?", //142
            "The Bahamas?", //143
            "Antananarivo?", //144
            "Australia?", //145
            "German Shepherd?", //146
            "Tyler Perry?", //147
            "Beijing?", //148
            "Rio de Janeiro?", //149
            "Hawaii?", //150
            "Dublin?", //151
            "Amsterdam?", //152
            "Theresa May?", //153
            "Jordan Spieth?", //154
            "Harry Houdini?", //155
            "G-Wagen?", //156
            "Las Vegas?", //157
            "Turkmenistan?", //158
            "Istanbul?", //159
            "curtis jackson?", //160
            "Marshall Mathers?", //161
            "Onika Tanya Maraj?", //162
            "Aspen?", //163
            "David Beckham?", //164
            "Aishwarya Rai?", //165
            "Brad Pitt?", //166
            "Angelina Jolie?", //167
            "CIA?", //168
            "NSA?", //169
            "Joe Biden?", //170
            "Donald Trump?", //171
            "Tissot?", //172
            "Tim Westwood?", //173
            "Clint Eastwood?", //174
            "The Leaning Tower?", //175
            "Simon cowell?", //176
            "puerto rico?", //177
            "Margaret thatcher?", //178
            "Muammar Gaddafi?", //179
            "Napoleon Bonaparte?", //180
            "Mumbai?", //181
            "Macau?", //182
            "ATM?", //183
            "Harley-davidson?", //184
            "hp?", //185
            "yeezy?", //186
            "Malcolm X?", //187
            "Zinox?", //188
            "Amancio Ortega?", //189
            "ZARA?", //190
            "Saddam Hussein?", //191
            "Osama bin Laden?", //192
            "Piers Morgan?", //193
            "Anthony Davis?", //194
            "Neymar?", //195
            "Grand Canyon?", //196
            "christ the redeemer statue?", //197
            "Giza?", //198
            "youtube?", //199
            "Kelvin darnell hart?", //200
            "Dwayne Douglas johnson?", //201
            "Rowan Sebastian Atkinson?", //202
            "Oprah Winfrey?", //203
            "Ellen lee degeneres?", //204
            "Gameboy?", //205
            "Steve Wozniak?", //206
            "Marie Curie?", //207
            "Pablo emilio escobar gaviria?", //208
            "Marsupial?", //209
            "Anaconda?", //210
            "Broderick Stephen Harvey?", //211
            "sir alexander chapman ferguson?", //212
            "vicente del bosque?", //213
            "martin luther king junior?", //214
            "john davison rockefeller?", //215
            "hillary diane rodham clinton?", //216
            "niko erik rosberg?", //217
            "blaise pascal?", //218
            "Alexander graham bell?", //219
            "Stephen hawking?", //220
            "Leonardo di ser piero da vinci?", //221
            "benjamin franklin?", //222
            "ray charles robinson?", //223
            "Robert nesta marley?", //224
            "Diana ernestine earle ross?", //225
            "the beatles?", //226
            "Elvis Aaron presley?", //227
            "Amy Winehouse?", //228
            "whitney elizabeth houston?", //229
            "james brown?", //230
            "william henry cosby?", //231
            "michael gerard tyson?", //232
            "orenthal james simpson?", //233
            "pelé?", //234
            "willard carroll smith junior?", //235
            "robert anthony de niro?", //236
            "george washington?", //237
            "ronald wilson reagan?", //238
            "sani abacha?", //239
            "john fitzgerald kennedy?", //240
            "joseph stalin?", //241
            "Kuwait?", //242
            "guatemala?", //243
            "nicaragua?", //244
            "damascus?", //245
            "vatican city?", //246
            "amazon rainforest?", //247
            "edinburg?", //248
            "kimberly kardashian west?", //249
            "michael fred phelps?",  //250
            "fidel castrol?", //251
            "djibouti?", //252
            "sean john combs?", //253
            "sir winston churchill?", //254
            "athens?", //255
            "Dubai?", //256
            "Abu dhabi?", //257
            "luxembourg?", //258
            "Heathrow Airport?", //259
            "Stanley kirk burrell?", //260
            "rocawear?", //261
            "Lexus?", //262
            "Acura?", //263
            "freetown?", //264
            "Cape town?", //265
            "Benghazi?", //266
            "Macintosh?", //267
            "Malaysia?", //268
            "kfc?", //269
            "Malibu?", //270
            "Budapest?", //271
            "Alienware?", //272
            "Honolulu?", //273
            "Caryn Elaine Johnson?", //274
            "Seth rogen?", //275
            "bbc?", //276
            "Justin drew bieber?", //277
            "Michael schumacher?", //278
            "Xperia?", //279
            "Kimono?", //280
            "Porsche?", //281
            "Atari?", //282
            "Maria Yuryevna sharapova?", //283
            "Earth?", //284
            "Audemars Piguet?", //285
            "Rolex?", //286
            "Christian Louboutin?", //287
            "Dwayne tyrone wade?", //288
            "Justin Gatlin?", //289
            "Ariana Grande-Butera?", //290
            "John Forbes Kerry?", //291
            "LCD?", //292
            "pdf?", //293
            "pin?", //294
            "wifi?", //295
            "suv?", //296
            "SD Card?", //297
            "Michael Richard Pence?", //298
            "Algeria?", //299
            "Stockholm?", //300
            "Raymond Wilfred Hudson?", //301
            "Pichai Sundararajan?", //302
            "Lupita Nyong'o?", //303
            "Hublot?", //304
            "Seoul?", //305
            "James Joseph Parsons?", //306
            "Fred Quimby?", //307
            "George Raymond Richard Martin?", //308
            "Koenigsegg Automotive AB?", //309
            "Marissa Mayer?", //310
            "idk?", //311
            "Ohio?", //312
            "Tata Motors?", //313
            "Adam Sandler?", //314
            "Folorunsho Alakija?", //315
            "Hassanal Bolkiah?", //316
            "Death Valley?", //317
            "Izamal?", //318
            "Jodhpur?", //319
            "Munich?", //320
            "Saint Petersburg?", //321
            "Montpellier?", //322
            "Morgan Freeman?", //323
            "Empire State Building?", //324
            "Nile River?", //325
            "Boa constrictor?", //326
            "Capybara?", //327
            "Emmanuel Macron?", //328
            "Wole Soyinka?", //329
            "MRI?", //330
            "btw?", //331
            "unesco?", //332
            "opec?", //333
            "au?", //334
            "Felipe VI?", //335
            "Idris Elba?", //336
            "Rotterdam?", //337
            "Chile?", //338
            "Rory McIlroy?", //339
            "lg?", //340
            "Nokia?", //341
            "Albania?", //342
            "BlackBerry Limited?", //343
            "Internet Explorer?", //344
            "William?", //345
            "Shawn Corey Carter?", //346
            "Fela Anikulapo Kuti?", //347
            "Berlin?", //348
            "Oscar Pistorius?", //349
            "Lake Victoria?", //350
            "Lake Chad?", //351
            "Steven Spielberg?", //352
            "Michael Bay?", //353
            "Aston Martin?", //354
            "Liliane Bettencourt?", //355
            "Alice Walton?", //356
            "Jeff Bezos?", //357
            "Mount Fuji?", //358
            "Helsinki?", //359
            "Julian Assange?", //360
            "Dennis Haysbert?", //361
            "Anthony Joshua?", //362
            "Bonny Island?", //363
            "Abubakar Tafawa Balewa?", //364
            "M.K.O. Abiola?", //365
            "Neil Armstrong?", //366
            "Yuri Gagarin?", //367
            "Uber?", //368
            "Benito Mussolini?", //369
            "Ray-Ban?", //370
            "Selma?", //371
            "Ernő Rubik?", //372
            "MTN?", //373
            "Rafael Nadal?", //374
            "Stanislas Wawrinka?", //375
            "Stephen Keshi?", //376
            "Arsène Wenger?", //377
            "GE?", //378
            "news?", //379
            "Central Park?", //380
            "Brussels?", //381
            "John Maynard Keynes?", //382
            "Harry Dexter White?", //383
            "Capcom?", //384
            "Ryan Seacrest?", //385
            "Christian Dior SE?", //386
            "Louis Vuitton?", //387
            "Moschino?", //388
            "Hugh Hefner?", //389
            "Dustin Moskovitz?", //390
            "Dave Chappelle?", //391
            "Congo River?", //392
            "Lake Baikal?", //393
            "Chester Bennington?", //394
            "Barcelona?", //395
            "Udaipur?", //396
            "New Mexico?", //397
            "Santa Fe?", //398
            "Laos?", //399
            "Mombasa?", //400
            "Mount Rushmore?", //401
            "Stonehenge?", //402
            "Easter Island?", //403
            "Taj Mahal?", //404
            "Niagara Falls?", //405
            "pos?", //406
            "George Clooney?", //407
            "Michelle Obama?", //408
            "David Blaine?", //409
            "Emmanuel Pacquiao?", //410
            "James Harden?", //411
            "Allen Iverson?", //412
            "Christopher George Wallace?", //413
            "Jet Li?", //414
            "Chimamanda Ngozi Adichie?", //415
            "Chinua Achebe?", //416
            "Thomas Sankara?", //417
            "Vancouver?", //418
            "Palo Alto?", //419
            "Michel Krieger?", //420
            "Nikola Tesla?", //421
            "al-Qarawiyyin library?", //422
            "Lake Karachay?", //423
            "Tahiti?", //424
            "Conor McGregor?", //425
            "Narendra Modi?", //426
            "Xi Jinping?", //427
            "Recep Tayyip Erdoğan?", //428
            "Daniel Ek?", //429
            "Tom Brady?", //430
            "Simone Biles?", //431
            "Leila de Lima?", //432
            "Fatou Bensouda?", //433
            "Yahya Jammeh?", //434
            "Viola Davis?", //435
            "Jeff Williams?", //436
            "Travis Kalanick?", //437
            "Susan Wojcicki?", //438
            "Evan Spiegel?", //439
            "Angela Merkel?", //440
            "Ali Khamenei?", //441
            "James Dimon?", //442
            "Benjamin Netanyahu?", //443
            "Bob Iger?", //444
            "ceo?", //445
            "cto?", //446
            "coo?", //447
            "cfo?", //448
            "cio?", //449
            "Bangladesh?", //450
            "mit?", //451
            "Ellen Johnson-Sirleaf?", //452
            "csi?", //453
            "Gareth Bale?", //454
            "carmelo anthony?", //455
            "Canelo Alvarez?", //456
            "Blake Griffin?", //457
            "wayne rooney?", //458
            "Wladimir Klitschko?", //459
            "Odell Beckham?", //460
            "Pretoria?", //461
            "Eden Hazard?", //462
            "yaya toure?", //463
            "Marilyn Monroe?", //464
            "Charles de Gaulle?", //465
            "Christopher Columbus?", //466
            "George Orwell?", //467
            "Paul McCartney?", //468
            "Plato?", //469
            "Pablo Picasso?", //470
            "Rosa Parks?", //471
            "Ludwig van Beethoven?", //472
            "Desmond Tutu?", //473
            "Benazir Bhutto?", //474
            "John Lennon?", //475
            "Cleopatra?", //476
            "Sigmund Freud?", //477
            "Carl Lewis?", //478
            "Prince Charles?", //479
            "Tim Berners-Lee?", //480
            "Lance Armstrong?", //481
            "Barranquilla?", //482
            "Roman Abramovich?", //483
            "Rupert Murdoch?", //484
            "Sacha Baron Cohen?", //485
            "Jimmy Wales?", //486
            "Stephen King?", //487
            "Aristotle?", //488
            "Adam Smith?", //489
            "Michelangelo?", //490
            "socrates?", //491
            "Kofi Annan?", //492
            "Christiaan Barnard?", //493
            "Loch Ness?", //494
            "Wrangel Island?", //495
            "Atacama Desert?", //496
            "Ayers Rock?", //497
            "Madeira?", //498
            "Melbourne?", //499
            "Victoria Falls?", //500
            "Prague?", //501
            "Dead Sea?", //502
            "Auckland?", //503
            "Tibet?", //504
            "Chichen Itza?", //505
            "Machu Picchu?", //506
            "Toronto?", //507
            "Jakarta?", //508
            "Bangkok?", //509
            "Sydney?", //510
            "Millau Viaduct?", //511
            "Pompeii?", //512
            "Rock of Gibraltar?", //513
            "Ephesus?", //514
            "Lake Hillier?", //515
            "Santorini?", //516
            "Derweze?", //517
            "Kuala Lumpur?", //518
            "Vienna?", //519
            "Cancún?", //520
            "Bucharest?", //521
            "Baku?", //522
            "Doha?", //523
            "RSVP?", //524
            "Karachi?", //525
            "Dhaka?", //526
            "Dakar?", //527
            "Tehran?", //528
            "Aleppo?", //529
            "Margaret Whitman?", //530
            "Montreal?", //531
            "Orlando Bloom?", //532
            "Kevin Systrom?", //533
            "Jack Dorsey?", //534
            "Eduardo Saverin?", //535
            "Jan Koum?", //536
            "Peter Gene Hernandez?", //537
            "Christopher Catesby Harington?", //538
            "Florence?", //539
            "Chefchaouen?", //540
            "Beirut?", //541
            "Kyoto?", //542
            "Shanghai?", //543
            "Edinburgh?", //544
            "Buenos Aires?", //545
            "Jack Ma?", //546
            "Chris Wanstrath?", //547
            "Stewart Butterfield?", //548
            "Michael Dell?", //549
            "Linus Benedict Torvalds?", //550
            "Zlatan Ibrahimovic?", //551
            "Mahendra Singh Dhoni?", //552
            "Phil Mickelson?", //553
            "Kei Nishikori?", //554
            "Ronda Rousey?", //555
            "Virat Kohli?", //556
            "Taylor Swift?", //557
            "Katheryn Elizabeth Hudson?", //558
            "Selena Marie Gomez?", //559
            "Robyn Rihanna Fenty?", //560
            "Thomas Jeffrey Hanks?", //561
            "Adele Laurie Adkins?", //562
            "Emma Charlotte Watson?", //563
            "Mel Gibson?", //564
            "Howard Stern?", //565
            "William john neeson?", //566
            "Aubrey Drake Graham?", //567
            "Kevin Spacey Fowler?", //568
            "ROTFL?", //569
            "yolo?", //570
            "ikr?", //571
            "Chadwick Boseman?", //572
            "Michael Bakari Jordan?", //573
            "Letitia Wright?", //574
            "Angelique Kidjoe?", //575
            "Salif Keïta?", //576
            "Yvonne Chaka Chaka?", //577
            "Femi Kuti?", //578
            "Haile Gebrselassie?", //579
            "Samuel Eto'o Fils?", //580
            "Alek Wek?", //581
            "Liya Kebede?", //582
            "Genevieve Nnaji?", //583
            "Koffi Olomide?", //584
            "Silvio Berlusconi?", //585
            "Nicolas Sarkozy?", //586
            "Billie Jean King?", //587
            "Sheldon Adelson?", //588
            "Ginni Rometty?", //589
            "Larry Ellison?", //590
            "Rex W. Tillerson?", //591
            "Janet Yellen?", //592
            "Caracas?", //593
            "Acapulco?", //594
            "San Pedro Sula?", //595
            "Tijuana?", //596
            "Durban?", //597
            "Cúcuta?", //598
            "Chihuahua?", //599
            "Salvador?", //600
            "Manila?", //601
            "Lagos?", //602
            "Kolkata?", //603
            "Nagoya?", //604
            "Bogotá?", //605
            "Lima?", //606
            "Taipei?", //607
            "Kinshasa?", //608
            "Ankara?", //609
            "Tel Aviv?", //610
            "Denver?", //611
            "Pittsburg?", //612
            "Cincinnati?", //613
            "Quito?", //614
            "Donetsk?", //615
            "Sacramento?", //616
            "Lubumbashi?", //617
            "Port Elizabeth?", //618
            "Nairobi?", //619
            "Dar es Salaam?", //620
            "Addis Ababa?", //621
            "Maputo?", //622
            "Kigali?", //623
            "Marrakesh?", //624
            "Ouagadougou?", //625
            "Mogadishu?", //626
            "Ibadan?", //627
            "Brazzaville?", //628
            "Kumasi?", //629
            "Osaka?", //630
            "Oslo?", //631
            "Ryan Coogler?", //632
            "Diego Armando Maradona?", //633
            "Shakira?", //634
            "Hugo Chávez?", //635
            "Che Guevara?", //636
            "Jackie Robinson?", //637
            "Galileo Galilei?", //638
            "Bono?", //639
            "Mike Shinoda?", //640
            "PSY?", //641
            "Johnny Depp?", //642
            "Stevie Wonder?", //643
            "Harland David Sanders?", //644
            "Billy Graham?", //645
            "James Earl Jones?", //646
            "Chuck Norris?", //647
            "Olusegun Obasanjo?", //648
            "Charlie Chaplin?", //649
            "Bill Clinton?", //650
            "Britney Jean Spears?", //651
            "Avril Lavigne?", //652
            "Jennifer Aniston?", //653
            "Carrie Underwood?", //654
            "Jessica Marie Alba?", //655
            "Megan Denise Fox?", //656
            "Fergie?", //657
            "Lindsay Lohan?", //658
            "Kristen Stewart?", //659
            "Sandra Bullock?", //660
            "Alicia Keys?", //661
            "Kaley Cuoco?", //662
            "Ayodeji Ibrahim Balogun?", //663
            "Davido?", //664
            "Eric Marlon Bishop?", //665
            "Christopher Brian Bridges?", //666
            "Faheem Rashad Najm?", //667
            "PR?", //668
            "Belcalis Almanzar?", //669
            "Abel Makkonen Tesfaye?", //670
            "Calvin Cordozar Broadus?", //671
            "Isabel dos Santos?", //672
            "Trevor Noah?", //673
            "N'Golo Kanté?", //674
            "Mohamed Salah?", //675
            "Mohamed Farah?", //676
            "Asisat Oshoala?", //677
            "Amina J. Mohammed?", //678
            "Abdel Fattah el-Sisi?", //679
            "Ngozi Okonjo-Iweala?", //680
            "Uhuru Muigai Kenyatta?", //681
            "Luanda?", //682
            "Agadir?", //683
            "Tripoli?", //684
            "Tunis?", //685
            "awol?", //686
            "mia?", //687
            "swat?", //688
            "DoA?", //689
            "eta?", //690
            "ufo?", //691
            "fyi?", //692
            "ssn?", //693
            "gmt?", //694
            "HR?", //695
            "cv?", //696
            "Antarctica?", //697
            "Guangzhou?", //698
            "Zambezi River?" //699

















    };
    String[] Answers = {
            "Nigeria", //0
            "United States of America",  //1
            "President of Russia",                        //2
            "co-founder of Apple inc.",                      //3
            "C.E.O. of Facebook",                        //4
            "First Governor-General of Nigeria",     //5
            "Nintendo",  //6
            "Sony's Game Console", //7
            "Author of 'Harry Potter' Book",//8
            "CNN", //9
            "Football", //10
            "Portugal", //11
            "Tennis", //12
            "United States of America", //13
            "co-founder of Microsoft corp.", //14
            "Tallest Building in the World", //15
            "CNN", //16
            "Cable News Network", //17
            "FIFA", //18
            "King of POP", //19
            "Emirates Telecommunications Corporation", //20
            "United States of America", //21
            "Moscow, Russia", //22
            "London, England", //23
            "Washington", //24
            "Founder of Ford Motor Company", //25
            "Rome, Italy", //26
            "United States of America", //27
            "Nazi Germany", //28
            "South Africa", //29
            "Spain", //30
            "Motorcycle", //31
            "Switzerland", //32
            "New York", //33
            "San Francisco", //34
            "California", //35
            "C.E.O. of Apple inc.", //36
            "Apple inc.", //37
            "Nigeria", //38
            "C.E.O. of Microsoft", //39
            "United Arab Emirates", //40
            "Dubai, United Arab Emirates", //41
            "co-founder of Google inc.", //42
            "A Country in Asia", //43
            "A Country in South Asia", //44
            "Elon Musk", //45
            "American", //46
            "National Aeronautics and Space Administration", //47
            "Social Media", //48
            "Of China", //49
            "German", //50
            "Morocco", //51
            "Italy", //52
            "Google", //53
            "C.E.O. of Netflix", //54
            "England", //55
            "Nepal", //56
            "Tanzania", //57
            "North Atlantic Treaty Organization", //58
            "Nike", //59
            "Just Do It", //60
            "Author of 'Oliver Twist' Book", //61
            "Author of 'Sherlock Holmes' Book", //62
            "Eddie Murphy", //63
            "Formula One Racing", //64
            "Golf", //65
            "Basketball", //66
            "United States of America", //67
            "Asia", //68
            "Jamaican", //69
            "Digital Satellite Television", //70
            "Titanic", //71
            "Africa", //72
            "Located in Dubai", //73
            "World's Tallest Hotel", //74
            "Japan", //75
            "Egypt", //76
            "World Health Organization", //77
            "Switzerland", //78
            "United Nations Children's Emergency Fund", //79
            "Invented the Airplane", //80
            "Longest Lake in the World", //81
            "South Korean Multinational Company", //82
            "Global Positioning System", //83
            "Impossible is Nothing", //84
            "As Soon As Possible", //85
            "Hugs and Kisses", //86
            "Laughing Out Loud", //87
            "Google", //88
            "Japan", //89
            "British Car and Aero-Engine Manufacturing Company", //90
            "Parent Organization of Rolls-Royce Motor Cars", //91
            "French Fashion Company", //92
            "Michael Jackson", //93
            "Federal Bureau of Investigation", //94
            "Supreme Leader of North Korea", //95
            "The Longest Bridge over Water in the World", //96
            "World's Longest Bridge", //97
            "American", //98
            "Mexican", //99
            "British Multinational", //100
            "Star Wars", //101
            "National Association for Stock Car Auto Racing", //102
            "Brazil", //103
            "Closed Circuit Television", //104
            "Microsoft", //105
            "Marvel Comics", //106
            "Basketball", //107
            "FIFA President", //108
            "Basketball", //109
            "Virgin Group", //110
            "Ghana", //111
            "Nigeria", //112
            "A Country", //113
            "Spain", //114
            "French", //115
            "French", //116
            "American", //117
            "Largest State in the United States of America", //118
            "France", //119
            "Italy", //120
            "Nigerian Vehicle Manufacturing Company", //121
            "Basketball", //122
            "Moto GP", //123
            "Tennis", //124
            "Britain", //125
            "Parent Organization of Lamborghini", //126
            "Boxing", //127
            "Longest Bridge in Africa", //128
            "Zimbabwe", //129
            "Football", //130
            "Poland", //131
            "Boxing", //132
            "India", //133
            "Italian Luxury Fashion House", //134
            "German Fashion Designer", //135
            "United States of America", //136
            "Skateboarder", //137
            "Football Coach", //138
            "Football", //139
            "Of Wales", //140
            "American Author", //141
            "Basketball", //142
            "A Country in North America", //143
            "Madagascar", //144
            "Oceania", //145
            "A Dog", //146
            "American Film Actor", //147
            "China", //148
            "City in Brazil", //149
            "A State", //150
            "Republic of Ireland", //151
            "Netherlands", //152
            "British Prime Minister", //153
            "Golf", //154
            "An Illusionist", //155
            "Mercedes-Benz", //156
            "Nevada", //157
            "A Country in Asia", //158
            "Turkey", //159
            "50 Cent", //160
            "Eminem", //161
            "Nicki Minaj", //162
            "United States of America", //163
            "Football", //164
            "Indian", //165
            "Actor", //166
            "Actress", //167
            "Central Intelligence Agency", //168
            "National Security Agency", //169
            "United States of America", //170
            "American Politician", //171
            "Swiss Watch Making Company", //172
            "British", //173
            "American", //174
            "Pisa, Italy", //175
            "America's Got Talent", //176
            "North America", //177
            "British", //178
            "Libya", //179
            "France", //180
            "India", //181
            "China", //182
            "Automated Teller Machine", //183
            "Motorcycle", //184
            "Hewlett-Packard", //185
            "Kanye West", //186
            "United States of America", //187
            "Computer", //188
            "co-founder of ZARA", //189
            "Spanish Clothing and Accessories", //190
            "Former President of Iraq", //191
            "Founder of al-Qaeda", //192
            "British", //193
            "Basketball", //194
            "Football", //195
            "United States of America", //196
            "Brazil", //197
            "Egypt", //198
            "Google", //199
            "A Comedian", //200
            "An Actor", //201
            "a.k.a Mr Bean.", //202
            "Talk Show Host", //203
            "Television Host", //204
            "Nintendo", //205
            "co-founder of Apple inc.", //206
            "Radioactivity", //207
            "Colombian", //208
            "Koala", //209
            "A Snake", //210
            "Author of 'Think Like a Man' Book", //211
            "Football", //212
            "Football", //213
            "Civil Right Activist", //214
            "American", //215
            "American Politician", //216
            "Formula One Racing", //217
            "Mathematician", //218
            "Invented the Telephone", //219
            "Theoretical Physicist", //220
            "Painted the 'Mona Lisa' Portrait", //221
            "United States of America", //222
            "Musician", //223
            "Jamaica", //224
            "Musician", //225
            "Rock Band", //226
            "King of Rock and Roll", //227
            "British", //228
            "American", //229
            "Musician", //230
            "Comedian", //231
            "Boxing", //232
            "American Football", //233
            "Brazil", //234
            "Actor", //235
            "Actor", //236
            "United States of America", //237
            "United States of America", //238
            "Nigeria", //239
            "United States of America", //240
            "Soviet Union", //241
            "A Country in Asia", //242
            "A Country in North America", //243
            "A Country", //244
            "Capital of Syria", //245
            "A Country in Europe", //246
            "South America", //247
            "A City in Texas, USA", //248
            "Television Personality", //249
            "Swimming", //250
            "Cuba", //251
            "A Country in Africa", //252
            "P Diddy", //253
            "Britain", //254
            "Greece", //255
            "City in the United Arab Emirates", //256
            "Capital of the United Arab Emirates", //257
            "Country in Europe", //258
            "England", //259
            "a.k.a MC Hammer", //260
            "American Clothing Retailer", //261
            "Toyota", //262
            "Honda", //263
            "Capital of Sierra Leone", //264
            "South Africa", //265
            "Libya", //266
            "Apple inc.", //267
            "Asia", //268
            "Kentucky Fried Chicken", //269
            "California", //270
            "Hungary", //271
            "Dell inc.", //272
            "Capital of Hawaii", //273
            "a.k.a Whoopi Goldberg", //274
            "Actor", //275
            "British Broadcasting Corporation", //276
            "Canadian", //277
            "Formula One", //278
            "Sony", //279
            "Japanese Traditional Garment", //280
            "German Automobile Manufacturer", //281
            "Arcade Game Company", //282
            "Tennis", //283
            "3rd Planet from the Sun", //284
            "Wristwatches", //285
            "Wristwatch Manufacturer", //286
            "French Fashion Designer", //287
            "Basketball", //288
            "United States of America", //289
            "American Singer", //290
            "American Politician", //291
            "Liquid Crystal Display", //292
            "Portable Document Format", //293
            "Personal Identification Number", //294
            "Wireless Fidelity", //295
            "Sport Utility Vehicle", //296
            "Secure Digital Card", //297
            "American Politician", //298
            "Africa", //299
            "Sweden", //300
            "Football", //301
            "C.E.O. of Google inc.", //302
            "Actress", //303
            "Swiss Luxury Watchmaker", //304
            "Capital of South Korea", //305
            "American Actor", //306
            "Tom and Jerry Cartoons", //307
            "A Game of Thrones", //308
            "Swedish Car Manufacturer", //309
            "C.E.O. of Yahoo!", //310
            "I Don't Know", //311
            "A State in the USA", //312
            "Parent Organization of Land Rover", //313
            "Actor", //314
            "Nigeria", //315
            "Sultan of Brunei", //316
            "United States of America", //317
            "City in Mexico", //318
            "City in India", //319
            "Capital of Bavaria", //320
            "City in Russia", //321
            "City in France", //322
            "American Actor", //323
            "United States of America", //324
            "Africa", //325
            "Snake", //326
            "Largest Rodent in the World", //327
            "President of France", //328
            "Nigeria", //329
            "Magnetic Resonance Imaging", //330
            "By The Way", //331
            "United Nations Educational, Scientific and Cultural Organization", //332
            "Organization of Petroleum Exporting Countries", //333
            "African Union", //334
            "King of Spain", //335
            "Actor", //336
            "City in the Netherlands", //337
            "South America", //338
            "Golf", //339
            "South Korean Company", //340
            "Finnish Multinational", //341
            "Europe", //342
            "Canadian Multinational Company", //343
            "Microsoft", //344
            "Shakespeare", //345
            "JAY-Z", //346
            "Nigeria", //347
            "Germany", //348
            "South Africa", //349
            "Africa", //350
            "Located in Africa", //351
            "American Movie Director", //352
            "Filmmaker", //353
            "British Car Manufacturer", //354
            "France", //355
            "American", //356
            "Amazon", //357
            "Japan", //358
            "Capital of Finland", //359
            "Founder of WikiLeaks", //360
            "Actor", //361
            "Boxing", //362
            "Africa", //363
            "Former Prime Minister of Nigeria", //364
            "Nigerian Politician", //365
            "First Person to Walk on the Moon", //366
            "First Person to Journey into Outer Space", //367
            "Transport Company", //368
            "Italy", //369
            "Eyeglasses", //370
            "Alabama", //371
            "Invented the Rubik's Cube", //372
            "South African Mobile Telecommunication Company", //373
            "Spain", //374
            "Tennis", //375
            "Football", //376
            "France", //377
            "General Electric", //378
            "Notable Events, Weather and Sports", //379
            "New York", //380
            "Belgium", //381
            "co-founder of World Bank", //382
            "co-founder of World Bank", //383
            "Video Game Company", //384
            "American", //385
            "French Luxury Goods Company", //386
            "French Fashion Company", //387
            "Italian Luxury Fashion House", //388
            "Playboy Mansion", //389
            "co-founder of Facebook", //390
            "Comedy", //391
            "World's Deepest River", //392
            "Russia", //393
            "Linkin Park", //394
            "Spain", //395
            "City in India", //396
            "United States of America", //397
            "City in New Mexico", //398
            "A Country in Asia", //399
            "A City in Kenya", //400
            "United States of America", //401
            "England", //402
            "Pacific Ocean", //403
            "India", //404
            "North America", //405
            "Point of Sale", //406
            "American Actor", //407
            "United States of America", //408
            "Illusionist", //409
            "Boxing", //410
            "Basketball", //411
            "Basketball", //412
            "The Notorious B.I.G.", //413
            "Chinese", //414
            "Nigerian", //415
            "Nigerian Novelist", //416
            "Burkina Faso", //417
            "Canada", //418
            "United States of America", //419
            "co-founder of Instagram", //420
            "Inventor", //421
            "The Oldest Library in the World", //422
            "Russia", //423
            "An Island", //424
            "Irish", //425
            "Prime Minister of India", //426
            "China", //427
            "President of Turkey", //428
            "co-founder of Spotify", //429
            "American Football", //430
            "Gymnastics", //431
            "Philippines", //432
            "Gambia", //433
            "Gambia", //434
            "Actress", //435
            "Apple", //436
            "American Businessman", //437
            "C.E.O. of Youtube", //438
            "co-founder of Snap inc.", //439
            "Chancellor of Germany", //440
            "Supreme Leader of Iran", //441
            "C.E.O. of JPMorgan Chase", //442
            "Prime Minister of Israel", //443
            "Disney", //444
            "Chief Executive Officer", //445
            "Chief Technology Officer", //446
            "Chief Operating Officer", //447
            "Chief Financial Officer", //448
            "Chief Information Officer", //449
            "Country in Asia", //450
            "Massachusetts Institute of Technology", //451
            "Africa's First Female President", //452
            "Crime Scene Investigation", //453
            "Football", //454
            "Basketball", //455
            "Boxing", //456
            "Basketball", //457
            "Football", //458
            "Boxing", //459
            "American Football", //460
            "Capital of South Africa", //461
            "Football", //462
            "Football", //463
            "American", //464
            "France", //465
            "Italian explorer", //466
            "Animal Farm", //467
            "The Beatles", //468
            "Greek Philosopher", //469
            "Spanish Painter", //470
            "Civil Right Activist", //471
            "German Composer", //472
            "South Africa", //473
            "Former Prime Minister of Pakistan",//474
            "Music Artist", //475
            "Egypt", //476
            "Austrian neurologist", //477
            "Track and Field Athlete", //478
            "of Wales", //479
            "Invented the World Wide Web", //480
            "American Cyclist", //481
            "City in Colombia", //482
            "Russian Businessman", //483
            "American media mogul", //484
            "English Actor", //485
            "co-founder of Wikipedia", //486
            "American Author", //487
            "Greek Philosopher", //488
            "Scottish Economist", //489
            "Italian sculptor and painter", //490
            "Greek Philosopher", //491
            "Ghana", //492
            "South African Surgeon", //493
            "Scotland", //494
            "Russia", //495
            "Chile", //496
            "Australia", //497
            "Portugal", //498
            "City in Australia", //499
            "Africa", //500
            "Czech Republic", //501
            "Asia", //502
            "New Zealand", //503
            "Asia", //504
            "North America", //505
            "Peru", //506
            "Canada", //507
            "Capital of Indonesia", //508
            "Thailand", //509
            "Australia", //510
            "Tallest Bridge in the World", //511
            "Italy", //512
            "Europe", //513
            "Turkey", //514
            "Australia", //515
            "Greece", //516
            "Turkmenistan", //517
            "Capital of Malaysia", //518
            "Capital of Austria", //519
            "City in Mexico", //520
            "Capital of Romania", //521
            "Capital of Azerbaijan", //522
            "Capital of Qatar", //523
            "Répondez s'il vous plait", //524
            "Pakistan", //525
            "Capital of Bangladesh", //526
            "Capital of Senegal", //527
            "Capital of Iran", //528
            "Syria", //529
            "C.E.O. of Hewlett Packard Enterprise", //530
            "Canada", //531
            "Actor", //532
            "co-founder of Instagram", //533
            "co-founder of Twitter", //534
            "co-founder of Facebook", //535
            "co-founder of WhatsApp Inc.", //536
            "a.k.a Bruno Mars", //537
            "Actor", //538
            "Italy", //539
            "Morocco", //540
            "Lebanon", //541
            "Japan", //542
            "China", //543
            "Scotland", //544
            "Argentina", //545
            "Alibaba Group", //546
            "co-founder of GitHub", //547
            "co-founder of Slack", //548
            "Founder of Dell Technologies", //549
            "Linux OS", //550
            "Sweden", //551
            "Cricket", //552
            "Golf", //553
            "Tennis", //554
            "professional wrestling", //555
            "Cricket", //556
            "Singer", //557
            "a.k.a Katy Perry", //558
            "American", //559
            "Barbadian", //560
            "Actor", //561
            "British Singer", //562
            "British Actress", //563
            "American Actor", //564
            "American", //565
            "Actor", //566
            "Singer", //567
            "American Actor", //568
            "Rolling on the Floor Laughing", //569
            "You Only Live Once", //570
            "I know, right", //571
            "Black Panther", //572
            "Actor", //573
            "Actress", //574
            "Beninese Singer", //575
            "Mali", //576
            "South Africa", //577
            "Nigeria", //578
            "Ethiopian athlete", //579
            "Cameroon", //580
            "South Sudan", //581
            "Ethiopian model", //582
            "Nigerian Actress", //583
            "Congolese Singer", //584
            "Italy", //585
            "France", //586
            "American Tennis Player", //587
            "American", //588
            "IBM", //589
            "co-founder of Oracle Corporation", //590
            "United States of America", //591
            "United States of America", //592
            "Capital of Venezuela", //593
            "City in Mexico", //594
            "City in Honduras", //595
            "City in Mexico", //596
            "City in South Africa", //597
            "City in Colombia", //598
            "City in Mexico", //599
            "City in Brazil", //600
            "Capital of the Philippines", //601
            "Nigeria", //602
            "India", //603
            "City in Japan", //604
            "Capital of Colombia", //605
            "Capital of Peru", //606
            "Capital of Taiwan", //607
            "Democratic Republic of the Congo", //608
            "Capital of Turkey", //609
            "City in Israel", //610
            "United States of America", //611
            "United States of America", //612
            "United States of America", //613
            "Capital of Ecuador", //614
            "Ukraine", //615
            "United States of America", //616
            "Africa", //617
            "South Africa", //618
            "Kenya", //619
            "Tanzania", //620
            "Capital of Ethiopia", //621
            "Capital of Mozambique", //622
            "Capital of Rwanda", //623
            "Morocco", //624
            "Capital of Burkina Faso", //625
            "Capital of Somalia", //626
            "The Largest City in West Africa", //627
            "Capital of the Republic of the Congo", //628
            "Ghana", //629
            "Japan", //630
            "Norway", //631
            "Film Director", //632
            "Football", //633
            "Colombia", //634
            "Venezuela", //635
            "Argentine", //636
            "Baseball", //637
            "Italian Astronomer", //638
            "Irish singer", //639
            "Musician", //640
            "South Korean Singer", //641
            "Actor", //642
            "Musician", //643
            "Founder of KFC", //644
            "American", //645
            "Actor", //646
            "Actor", //647
            "Nigeria", //648
            "Comedy", //649
            "United States of America", //650
            "Singer", //651
            "Canadian", //652
            "Actress", //653
            "Singer", //654
            "American Actress", //655
            "American Actress", //656
            "The Black Eyed Peas", //657
            "Actress", //658
            "Actress", //659
            "Actress", //660
            "Singer", //661
            "Actress", //662
            "Wizkid", //663
            "David Adedeji Adeleke", //664
            "Jamie Foxx", //665
            "Ludacris", //666
            "T-Pain", //667
            "Public Relations", //668
            "Cardi B", //669
            "The Weeknd", //670
            "Snoop Dogg", //671
            "Angola", //672
            "South African comedian", //673
            "Football", //674
            "Football", //675
            "Britain", //676
            "Football", //677
            "Nigeria", //678
            "Egypt", //679
            "Nigeria", //680
            "Kenya", //681
            "Capital of Angola", //682
            "City in Morocco", //683
            "Libya", //684
            "Capital of Tunisia", //685
            "Absent Without Leave", //686
            "Missing In Action", //687
            "Special Weapons And Tactics", //688
            "Dead On Arrival", //689
            "Estimated Time of Arrival", //690
            "Unidentified Flying Object", //691
            "For Your Information", //692
            "Social Security Number", //693
            "Greenwich Mean Time", //694
            "Human Resources", //695
            "Curriculum Vitae", //696
            "A Continent", //697
            "City in China", //698
            "Africa" //699






    };

    String[] Options = new String[]{
            "Nigeria", "Ghana", "Kenya",//0,1,2
            "Britain", "Pakistan", "United States of America", //3,4,5
            "President of Russia", "Russian prime minister", "President of Poland", //6,7,8
            "co-founder of Lenovo", "co-founder of Apple inc.", "founder of microsoft",  //9,10,11
            "founder of microsoft", "C.E.O. of Facebook", "founder of pixar studios",  //12,13,14
            "First British Prime minister", "First Governor-General of Nigeria", "First Governor of Hong Kong", //15,16,17
            "Nintendo", "Sega", "AlienWare",  //18,19,20
            "Sony's Television Station", "A website", "Sony's Game Console", //21,22,23
            "Author of 'Twilight' Book", "Author of 'Harry Potter' Book", "Author of 'The Lord of the Rings' Book",//24,25,26
            "BBC", "CNN", "CBC", //27,28,29
            "Basketball", "Football", "Baseball", //30,31,32
            "Spain", "Portugal", "England", //33,34,35
            "Tennis", "Football", "Boxing", //36,37,38
            "United States of America", "Great Britain", "Canada", //39,40,41
            "co-founder of Apple inc.", "co-founder of Microsoft corp.", "co-founder of Reddit inc. ", //42,43,44
            "Tallest Hotel in the World", "Tallest Building in the World", "Longest Bridge in the World", //45,46,47
            "CBC", "NBC", "CNN", //48,49,50
            "Cartoon Network", "Cable News Networth", "Cable News Network", //51,52,53
            "FIBA", "FIFA", "EUFA", //54,55,56
            "King of POP", "godfather of SOUL", "King of ROCK 'n' ROLL", //57,58,59
            "Emirates Telecommunications Corporation", "Emirates Satellites Corporation", "Emirates Telecommunications Satellites Corporation", //60,61,62
            "United Arab Emirates", "United States of America", "United Kingdom", //63,64,65
            "Moshkovo, Russia", "Moscow, Russia", "Mosalsk, Russia", //66,67,68
            "London, England", "Birmingham, England", "Bradford, England", //69,70,71
            "Wellington", "New York", "Washington", //72,73,74
            "Founder of Ford Motorcycle", "C.E.O. of Ford Motor Company", "Founder of Ford Motor Company", //75,76,77
            "Athens, Greece", "Turin, Italy", "Rome, Italy", //78,79,80
            "Great Britain", "United States of America", "Russia", //81,82,83
            "Soviet Union", "United Kingdom", "Nazi Germany", //84,85,86
            "Zimbabwe", "South Africa", "Cameroon", //87,88,89
            "Spain", "Argentina", "Brazil", //90,91,92
            "Automobile", "Motorcycle", "Boat", //93,94,95
            "Russia", "Ukraine", "Switzerland", //96,97,98
            "Washington D.C.", "California", "New York", //99,100,101
            "Los Angeles", "Florida", "San Francisco", //102,103,104
            "California", "Washington D.C.", "New York", //105,106,107
            "C.E.O. of Samsung", "C.E.O. of Apple inc.", "C.E.O. of Microsoft", //108,109,110
            "Samsung", "Apple inc.", "Microsoft", //111,112,113
            "Niger", "Ivory Coast", "Nigeria", //114,115,116
            "C.E.O. of Microsoft", "C.E.O. of Lenovo", "C.E.O. of Accer", //117,118,119
            "Qatar", "Saudi Arabia", "United Arab Emirates", //120,121,122
            "Dubai, Qatar", "Qatar, United Arab Emirates", "Dubai, United Arab Emirates", //123,124,125
            "co-founder of twitter", "co-founder of Google inc.", "co-founder of Reddit", //126,127,128
            "The Capital of Saudi Arabia", "A Country in Asia", "A City in Saudi Arabia", //129,130,131
            "A City in Sri Lanka", "The Capital of Mauritius", "A Country in South Asia", //132,133,134
            "Bill Nye", "Mary Gonzales", "Elon Musk", //135,136,137
            "Mexican", "Cuban", "American", //138,139,140
            "National Air Space Administration", "National Aeronautics and Space Advancements", "National Aeronautics and Space Administration", //141,142,143
            "Instant Delivery Service", "Social Media", "Transportation Service", //144,145,146
            "Of Jericho", "Of China", "Of North Korea", //147,148,149
            "Russian", "American", "German", //150,151,152
            "Jamaica", "Morocco", "Algeria", //153,154,155
            "United States of America", "Spain", "Italy", //156,157,158
            "Microsoft", "Google", "Mozilla", //159,160,161
            "C.E.O. of Reddit", "C.E.O. of Amazon", "C.E.O. of Netflix", //162,163,164
            "Scotland", "England", "Ireland", //165,166,167
            "China", "Nepal", "Tanzania", //168,169,170
            "Kuwait", "Sudan", "Tanzania", //171,172,173
            "North Atlantic Treaty Organization", "National Address Treaty Organization", "North Atlantic Tactical Operation", //174,175,176
            "Adidas", "Reebok", "Nike", //177,178,179
            "Let's Do it", "Just It", "Just Do It", //180,181,182
            "Author of 'Sherlock Holmes' Book", "Author of 'Oliver Twist' Book", "Author of 'Just After Sunset' Book", //183,184,185
            "Author of 'Oliver Twist' Book", "Author of 'Twilight' Book", "Author of 'Sherlock Holmes' Book", //186,187,188
            "Cedric the Entertainer", "Eddie Murphy", "Bernie Mac", //189,190,191
            "Nascar", "Super Bike Racing", "Formula One Racing", //192,193,194
            "Cricket", "Hockey", "Golf", //195,196,197
            "Baseball", "Basketball", "Bowling", //198,199,200
            "Great Britain", "United States of America", "Canada", //201,202,203
            "Europe", "Asia", "South America", //204,205,206
            "American", "Algerian", "Jamaican", //207,208,209
            "Dish Television", "Digital Satellite Television", "Display Service Television", //210,211,212
            "Deep Blue Sea", "Anaconda", "Titanic", //213,214,215
            "Asia", "South America", "Africa", //216,217,218
            "World's Tallest Hotel", "World's Tallest building", "Located in Dubai", //219,220,221
            "World's Largest Shopping Mall", "World's Tallest Hotel", "World's Deepest Underwater Hotel", //222,223,224
            "Hong Kong", "Japan", "China", //225,226,227
            "Egypt", "Ghana", "Liberia", //228,229,230
            "Whole Health Operations", "World Health Organization", "World Health Optimization", //231,232,233
            "United States of America", "Switzerland", "New Zealand", //234,235,236
            "Unlimited National Children's Emergency Fund", "United Nations Children's Emergency Foundation", "United Nations Children's Emergency Fund", //237,238,239
            "Invented the Airballoon", "Invented the Airplane", "Invented the telephone", //240,241,242
            "Shortest Lake in the World", "Longest Lake in the World", "Dirtiest Lake in the World", //243,244,245
            "South Korean Multinational Company", "American Multinational Company", "Chinese Multinational Company", //246,247,248
            "Global Positioning System", "Global Pointing System", "Global Positioning Strategy", //249,250,251
            "I am what I am", "Impossible is Nothing", "Just do it", //252,253,254
            "As Soon As Possible", "As Sleek As Possible", "All Sleek All Portable", //255,256,257
            "Hugs and Kisses", "Ying and Yang", "Yes and No", //258,259,260
            "loads of love", "Laughing Out Loud", "Love of Life", //261,262,263
            "Microsoft", "Google", "Apple", //264,265,266
            "China", "Hong Kong", "Japan", //267,268,269
            "American Car and Aero-Engine Manufacturing Company", "German Car and Aero-Engine Manufacturing Company", "British Car and Aero-Engine Manufacturing Company", //270,271,272
            "British Automobile Manufacturing Company", "Parent Organization of Rolls-Royce Motor Cars", "A subsidiary of Rolls-Royce Motor Cars", //273,274,275
            "American Fashion Company", "French Fashion Company", "British Fashion Company", //276,277,278
            "Michael Jackson", "Elvis Presley", "James Brown", //279,280,281
            "Federal Board of Investigation", "Federal Bureau of Investigation", "First Board of Investigation", //282,283,284
            "Supreme Leader of North Korea", "President of South Korea", "Vice President of South Korea", //285,286,287
            "The Longest Lake in the World", "The Longest Bridge over Water in the World", "The Deepest lake in the World", //288,289,290
            "World's Shortest Bridge", "World's Longest Bridge", "World's Largest Bridge", //291,292,293
            "American", "British", "Italian", //294,295,296
            "Cuban", "Mexican", "Colombian", //297,298,299
            "British Multinational", "American Multinational", "Canadian Multinational", //300,301,302
            "Star Trek", "Star Gate", "Star Wars", //303,304,305
            "National Association for Stock Car Auto Racing", "National Association for Sleek Car Auto Racing", "North Atlantic first Sleek Car Auto Racing", //306,307,308
            "Brazil", "Argentina", "Spain", //309,310,311
            "Closed Circuit Television", "Controlled Circuit Television", "Close Control Television", //312,313,314
            "Microsoft", "Nintendo", "Atari", //315,316,317
            "Marvel Comics", "DC Comics", "Capcom", //318,319,320
            "Basketball", "Baseball", "Football", //321,322,323
            "FIFA President", "FIBA President", "EUFA President", //324,325,326
            "Basketball", "Baseball", "Football", //327,328,329
            "Virgin Group", "Lufthansa", "British Airways", //330,331,332
            "Cameroon", "Ghana", "Mali", //333,334,335
            "Côte d'Ivoire", "Nigeria", "Cameroon", //336,337,338
            "A State", "A Capital", "A Country", //339,340,341
            "Spain", "France", "Ukraine", //342,343,344
            "French", "German", "Italian", //345,346,347
            "French", "American", "Italian", //348,349,350
            "American", "British", "Colombian", //351,352,353
            "Largest State in the United States of America", "Located in Russia", "The Capital of Iceland", //354,355,356
            "France", "Russia", "Germany", //357,358,359
            "France", "Italy", "Bulgaria", //360,361,362
            "Nigerian Vehicle Manufacturing Company", "Japanese Vehicle Manufacturing Company", "Korean Vehicle Manufacturing Company", //363,364,365
            "Ice Hockey", "Basketball", "Baseball", //366,367,368
            "Moto GP", "Formular One", "Tennis", //369,370,371
            "Tennis", "Baseball", "Cricket", //372,373,374
            "Britain", "Scotland", "Ireland", //375,376,377
            "Parent Organization of Lamborghini", "Italian Automobile Manufacturer", "A Subsidiary Division of BMW", //378,379,380
            "Boxing", "Basketball", "Baseball", //381,382,383
            "Longest Bridge in Africa", "Located in Nigeria", "Shortest Bridge in Africa", //384,385,386
            "Zimbabwe", "Kenya", "Zambia", //387,388,389
            "Football", "Basketball", "Golf", //390,391,392
            "Poland", "Czech Republic", "Cyprus", //393,394,395
            "Boxing", "Karate", "Wrestling", //396,397,398
            "Sri Lanka", "India", "Bhutan", //399,400,401
            "Italian Luxury Fashion House", "French Luxury Fashion House", "German Luxury Fashion House", //402,403,404
            "German Fashion Designer", "British Fashion Designer", "Italian Fashion Designer", //405,406,407
            "United States of America", "South Africa", "Mexico", //408,409,410
            "Skateboarder", "British Comedian and Writer", "Car Racer", //411,412,413
            "Football Coach", "Basketball Coach", "Tennis Coach", //414,415,416
            "Football", "Tennis", "Cycling", //417,418,419
            "Of Wales", "Of England", "Of Scotland", //420,421,422
            "American Author", "Italian Author", "German Author", //423,424,425
            "Basketball", "Football", "Golf", //426,427,428
            "A Country in North America", "A Country in Europe", "A City in South America", //429,430,431
            "Madagascar", "Angola", "Liberia", //432,433,434
            "Europe", "Oceania", "North America", //435,436,437
            "A Dog", "A Cat", "A Sheep", //438,439,440
            "American Film Actor", "British Film Actor", "Irish Film Actor", //441,442,443
            "China", "Japan", "North Korea", //444,445,446
            "City in Brazil", "City in Portugal", "City in Argentina", //447,448,449
            "A Country", "A State", "A Capital", //450,451,452
            "Republic of Ireland", "South Africa", "Netherlands", //453,454,455
            "Denmark", "Belgium", "Netherlands", //456,457,458
            "British Prime Minister", "Irish Prime Minister", "Scottish Prime Minister", //459,460,461
            "Basketball", "Golf", "Football", //462,463,464
            "An Illusionist", "A Footballer", "An Actor", //465,466,467
            "Mercedes-Benz", "Toyota", "Jeep", //468,469,470
            "Nevada", "New York", "California", //471,472,473
            "A Country in Asia", "A City in Turkey", "A Country in Europe", //474,475,476
            "Turkey", "Algeria", "Morocco", //477,478,479
            "50 Cent", "Eminem", "Jay-Z", //480,481,482
            "Jay-Z", "Eminem", "Dr Dre", //483,484,485
            "Nicki Minaj", "Lil' Kim", "Lil Mama", //486,487,488
            "United States of America", "Netherlands", "Germany", //489,490,491
            "Basketball", "Football", "Golf", //492,493,494
            "Indian", "Sri Lankan", "American", //495,496,497
            "Actor", "Footballer", "Boxer", //498,499,500
            "Actress", "Tennis Player", "Musician", //501,502,503
            "Central Intelligence Agency", "Cyber Intelligence Agency", "Core Intelligence Agency", //504,505,506
            "National Security Agency", "National Systems Agency", "National Surrogate Agency", //507,508,509
            "United States of America", "Afganistan", "Germany", //510,511,512
            "American Politician", "British Politician", "Mexican Politician", //513,514,515
            "Swiss Watch Making Company", "American Watch Making Company", "British Watch Making Company", //516,517,518
            "British", "American", "German", //519,520,521
            "American", "British", "German", //522,523,524
            "Pisa, Italy", "Milan, Italy", "Verona, Italy", //525,526,527
            "America's Got Talent", "Fear Factor", "Family Feud", //528,529,530
            "South America", "North America", "Asia", //531,532,533
            "British", "American", "German", //534,535,536
            "Liberia", "Libya", "Egypt", //537,538,539
            "United States of America", "France", "Britain", //540,541,542
            "India", "China", "Japan", //543,544,545
            "China", "Japan", "Mexico", //546,547,548
            "Automated Teller Machine", "Automatic Teller Machine", "Automated Transaction Machine", //549,550,551
            "Motorcycle", "Boat", "Airplane", //552,553,554
            "Hewlett-Packard", "Hewlet-Packard", "Hewlet-Packerd", //555,556,557
            "Kanye West", "John Legend", "Kelvin Durant", //558,559,560
            "United States of America", "Britain", "South Africa", //561,562,563
            "Computer", "Motorcycle", "Train", //564,565,566
            "co-founder of ZARA", "co-founder of KAPPA", "co-founder of FILA", //567,568,569
            "Spanish Clothing and Accessories", "Italian Clothing and Accessories", "french Clothing and Accessories", //570,571,572
            "Former President of Iraq", "Former President of Afganistan", "Former President of Iran", //573,574,575
            "Founder of al-Shabab", "Founder of al-Qaeda", "Founder of ISIS", //576,577,578
            "American", "German", "British", //579,580,581
            "Football", "Golf", "Basketball", //582,583,584
            "Baseball", "Football", "Basketball", //585,586,587
            "United States of America", "Africa", "Mexico", //588,589,590
            "Africa", "Brazil", "France", //591,592,593
            "Egypt", "Israel", "Iraq", //594,595,596
            "Yahoo", "Google", "Microsoft", //597,598,599
            "A Journalist", "UFC Fighter", "A Comedian", //600,601,602
            "An Actor", "A Footballer", "A Journalist", //603,604,605
            "a.k.a Mr Bean.", "A Musician", "A Basketballer", //606,607,608
            "Talk Show Host", "Musician", "Athlete", //609,610,611
            "Television Host", "CNN", "Musician", //612,613,614
            "Sony", "Nintendo", "Sega", //615,616,617
            "co-founder of Apple inc.", "co-founder of Samsung", "co-founder of Microsoft", //618,619,620
            "Radioactivity", "Electromagnetism", "Atomic Structure", //621,622,623
            "Colombian", "Mexican", "Bolivian", //624,625,626
            "Koala", "Lion", "Kiwi", //627,628,629
            "A Snake", "A Dog", "A Fish", //630,631,632
            "Author of 'Think Like a Man' Book", "A Musician", "Author of '50 Shades of Grey' Book", //633,634,635
            "Football", "Basketball", "Golf", //636,637,638
            "Golf", "Football", "Hockey", //639,640,641
            "Civil Right Activist", "Journalist", "Politician", //642,643,644
            "American", "British", "German", //645,646,647
            "American Politician", "British Politician", "French Politician", //648,649,650
            "Formula One Racing", "Football", "Nascar", //651,652,653
            "Mathematician", "Musician", "Physicist", //654,655,656
            "Invented the Telephone", "Invented the Airplane", "Invented the Automobile", //657,658,659
            "Theoretical Physicist", "Basketballer", "Footballer", //660,661,662
            "Painted the 'Mona Lisa' Portrait", "Painted the 'Guernica' Portrait", "Painted the 'Las Meninas' Portrait", //663,664,665
            "United States of America", "Germany", "England", //666,667,668
            "Musician", "Actor", "Journalist", //669,670,671
            "Jamaica", "United States of America", "South Africa", //672,673,674
            "Musician", "Actress", "Talk Show Host", //675,676,677
            "Rock Band", "Country Music Band", "Jazz Music Band", //678,679,680
            "King of Rock and Roll", "King of Pop", "King of Jazz", //681,682,683
            "British", "American", "French", //684,685,686
            "British", "American", "German", //687,688,689
            "Musician", "Actor", "Basketballer", //690,691,692
            "Comedian", "Musician", "Politician", //693,694,695
            "Boxing", "Football", "Golf", //696,697,698
            "American Football", "Football", "Basketball", //699,700,701
            "Brazil", "Argentina", "Colombia", //702,703,704
            "Actor", "Athlete", "Journalist", //705,706,707
            "Actor", "Politician", "Journalist", //708,709,710
            "United States of America", "Canada", "Australia", //711,712,713
            "United States of America", "France", "Germany", //714,715,716
            "Nigeria", "Liberia", "Libya", //717,718,719
            "United States of America", "Canada", "Australia", //720,721,722
            "Soviet Union", "Nazi Germany", "United Kingdom", //723,724,725
            "A Country in Asia", "A State in Europe", "A Country in Europe", //726,727,728
            "A Country in North America", "A Country in South America", "A Country in Africa", //729,730,731
            "A Country", "A State", "A Capital", //732,733,734
            "Capital of Syria", "Capital of israel", "Capital of Jordan", //735,736,737
            "A Country in Europe", "A Country in North America", "A City in Russia", //738,739,740
            "South America", "Asia", "Europe", //741,742,743
            "A City in Texas, USA", "Capital of Scotland", "A Country in Europe", //744,745,746
            "Television Personality", "Journalist", "Politician", //747,748,749
            "Swimming", "Football", "Basketball", //750,751,752
            "Cuba", "Mexico", "Colombia", //753,754,755
            "A Country in Africa", "A City in Africa", "A State in Africa", //756,757,758
            "P Diddy", "J Cole", "G Eazy", //759,760,761
            "United States of America", "Britain", "Canada", //762,763,764
            "Italy", "Greece", "Spain", //765,766,767
            "City in the United Arab Emirates", "Capital of the United Arab Emirates", "Capital of Qatar", //768,769,770
            "City in Qatar", "Capital of the United Arab Emirates", "Capital of Dubai", //771,772,773
            "Country in Europe", "Capital of Sweden", "City in Europe", //774,775,776
            "England", "United States of America", "Germany", //777,778,779
            "a.k.a MC Hammer", "a.k.a P Diddy", "a.k.a MC Pliers", //780,781,782
            "American Clothing Retailer", "German Clothing Retailer", "Spanish Clothing Retailer", //783,784,785
            "Toyota", "Honda", "Mercedes-Benz", //786,787,788
            "Toyota", "Honda", "Mercedes-Benz", //789,790,791
            "Capital of Sierra Leone", "Capital of Angola", "Capital of South Africa", //792,793,794
            "South Africa", "Sierra Leone", "Algeria", //795,796,797
            "Libya", "Syria", "Egypt", //798,799,800
            "Apple inc.", "Microsoft corp.", "Dell inc.", //801,802,803
            "Asia", "Europe", "North America", //804,805,806
            "Kentucky Fried Chicken", "Kentucky Fresh Chicken", "Kenturkey Fried Chicken", //807,808,809
            "California", "Florida", "Miami", //810,811,812
            "China", "Hungary", "Italy", //813,814,815
            "Dell inc.", "Microsoft corp.", "Lenovo", //816,817,818
            "Capital of Hawaii", "Country in Europe", "City in South America", //819,820,821
            "a.k.a Whoopi Goldberg", "a.k.a Lady Gaga", "a.k.a The Church Lady", //822,823,824
            "Actor", "Footballer", "Musician", //825,826,827
            "British Broadcasting Corporation", "British Broadband Corporation", "British Broadcasting Connection", //828,829,830
            "Canadian", "British", "German", //831,832,833
            "Formula One", "Football", "Golf", //834,835,836
            "Sony", "Samsung", "Nokia", //837,838,839
            "Japanese Traditional Garment", "Chinese Traditional Garment", "Korean Traditional Garment", //840,841,842
            "German Automobile Manufacturer", "Italian Automobile Manufacturer", "French Automobile Manufacturer", //843,844,845
            "Arcade Game Company", "Automobile Manufacturing Company", "Japanese Clothing Retailer", //846,847,848
            "Tennis", "Basketball", "Volleyball", //849,850,851
            "3rd Planet from the Sun", "5th Planet from the Sun", "2nd Planet from the Sun", //852,853,854
            "Wristwatches", "Shoes", "Belts", //855,856,857
            "Wristwatch Manufacturer", "Automobile Manufacturer", "Phone Manufacturer", //858,859,860
            "French Fashion Designer", "Italian Fashion Designer", "Spanish Fashion Designer", //861,862,863
            "Basketball", "Football", "Boxing", //864,865,866
            "United States of America", "Jamaica", "Canada", //867,868,869
            "American Singer", "American Footballer", "French Singer", //870,871,872
            "American Politician", "Founder of Forbes Magazine", "CEO of Forbes Magazine", //873,874,875
            "Liquid Crystal Display", "Large Crystal Display", "Large Clear Display", //876,877,878
            "Portable Document Format", "Portable Document File", "Processed Document Format", //879,880,881
            "Personal Identification Number", "Product Identification Number", "Professional Identification Number", //882,883,884
            "Wireless Fidelity", "Wireless Functions Incorporated", "Wireless Functions Inside", //885,886,887
            "Sport Utility Vehicle", "Special Use Vehicle", "Sport Use Vehicle", //888,889,890
            "Secure Digital Card", "Sensitive Digital Card", "Simple Display Card", //891,892,893
            "American Politician", "Footballer", "Musician", //894,895,896
            "Africa", "Europe", "Asia", //897,898,899
            "Sweden", "England", "Wales", //900,901,902
            "Football", "Basketball", "Golf", //903,904,905
            "C.E.O. of Google inc.", "Indian Actor", "Sri Lankan Actor", //906,907,908
            "Actress", "Talk Show Host", "Musician", //909,910,911
            "Swiss Luxury Watchmaker", "Spanish Clothing Retailer", "Italian Luxury Watchmaker", //912,913,914
            "Capital of South Korea", "Capital of North Korea", "Capital of China", //915,916,917
            "American Actor", "British Actor", "Canadian Actor", //918,919,920
            "Tom and Jerry Cartoons", "Pinky and the Brain", "Scooby-Doo", //921,922,923
            "A Game of Thrones", "Fifty Shades of Grey", "The Hunger Games", //924,925,926
            "Swedish Car Manufacturer", "Italian Car Manufacturer", "German Car Manufacturer", //927,928,929
            "C.E.O. of Yahoo!", "American Actress", "Musician", //930,931,932
            "I Don't Know", "I Do Know", "I Don't Knock", //933,934,935
            "A State in the USA", "Capital of Hawaii", "A Country in North America", //936,937,938
            "Parent Organization of Land Rover", "German Car Manufacturer", "Parent Organization of Nissan", //939,940,941
            "Actor", "Footballer", "Basketballer", //942,943,944
            "Nigeria", "Britain", "United States of America", //945,946,947
            "Sultan of Brunei", "Emir of Qatar", "King of Saudi Arabia", //948,949,950
            "United States of America", "Russia", "Afganistan", //951,952,953
            "City in Mexico", "City in India", "City in Spain", //954,955,956
            "City in Argentina", "City in India", "City in France", //957,958,959
            "Capital of Bavaria", "A State in Germany", "Capital of Berlin", //960,961,962
            "City in Russia", "City in Germany", "City in Sweden", //963,964,965
            "City in France", "City in Spain", "City in Portugal", //966,967,968
            "American Actor", "British Actor", "Canadian Actor", //969,970,971
            "United States of America", "Britain", "Switzerland", //972,973,974
            "Africa", "Asia", "South America", //975,976,977
            "Snake", "Fish", "Dog", //978,979,980
            "Largest Rodent in the World", "Biggest Dog in the World", "Biggest Fish in the World", //981,982,983
            "President of France", "President of South Africa", "President of Italy", //984,985,986
            "Nigeria", "Ghana", "South Africa", //987,988,989
            "Magnetic Resonance Imaging", "Magnetic Ray Imaging", "Magnetic Ray Integration", //990,991,992
            "By The Way", "Be The Way", "By The Wax", //993,994,995
            "United Nations Educational, Scientific and Cultural Organization", "United Nations Exporting, Scientific and Controlling Organization", "United Nations Exporting, Scientific and Cultural Organization", //996,997,998
            "Organization of Petroleum Exporting Countries", "Organization of Petroleum Exchanging Countries", "Organization of Petroleum Exporting Counties", //999,1000,1001
            "African Union", "African Unity", "African Uprising", //1002,1003,1004
            "King of Belgium", "King of Spain", "King of Brazil", //1005,1006,1007
            "Actor", "Basketballer", "Footballer", //1008,1009,1010
            "City in the Netherlands", "City in Scotland", "City in Denmark", //1011,1012,1013
            "South America", "Asia", "North America", //1014,1015,1016
            "Golf", "Basketball", "Tennis", //1017,1018,1019
            "South Korean Company", "American Company", "Japanese Company", //1020,1021,1022
            "Finnish Multinational", "American Multinational", "Japanese Multinational", //1023,1024,1025
            "Europe", "North America", "Asia", //1026,1027,1028
            "Canadian Multinational Company", "American Multinational Company", "British Multinational Company", //1029,1030,1031
            "Microsoft", "Google", "Oracle", //1032,1033,1034
            "Shakespeare", "Shakespear", "Shakespare", //1035,1036,1037
            "JAY-Z", "Lil Wayne", "50 Cent", //1038,1039,1040
            "Nigeria", "Ghana", "South Africa", //1041,1042,1043
            "Germany", "China", "Russia", //1044,1045,1046
            "South Africa", "United States of America", "Brazil", //1047,1048,1049
            "North America", "Europe", "Africa", //1050,1051,1052
            "Located in Africa", "Located in Asia", "Located in Europe", //1053,1054,1055
            "Russian Movie Director", "American Movie Director", "British Movie Director", //1056,1057,1058
            "Filmmaker", "Footballer", "Basketballer", //1059,1060,1061
            "British Car Manufacturer", "Italian Car Manufacturer", "German Car Manufacturer", //1062,1063,1064
            "France", "Britain", "Italy", //1065,1066,1067
            "American", "British", "Canadian", //1068,1069,1070
            "Amazon", "Alibaba Group", "eBay", //1071,1072,1073
            "Japan", "China", "Finland", //1074,1075,1076
            "Capital of Iceland", "Capital of Finland", "Capital of Ireland", //1077,1078,1079
            "Founder of Wikipedia", "Founder of WikiLeaks", "Founder of Twitter", //1080,1081,1082
            "Actor", "Footballer", "Basketballer", //1083,1084,1085
            "Boxing", "Football", "Basketball", //1086,1087,1088
            "Africa", "South America", "Europe", //1089,1090,1091
            "Former Prime Minister of Nigeria", "Former President of Nigeria", "Former Prime Minister of Ghana", //1092,1093,1094
            "Nigerian Politician", "Ghanian Politician", "Liberian Politician", //1095,1096,1097
            "First Person to Walk on the Moon", "First Person to Journey into outer space", "First Person to Walk on Mars", //1098,1099,1100
            "First Person to Walk on the Moon", "First Person to Journey into Outer Space", "First Person to Walk on Mars", //1101,1102,1103
            "Transport Company", "Telecommunications Company", "Internet Service Provider", //1104,1105,1106
            "Italy", "Russia", "France", //1107,1108,1109
            "Eyeglasses", "Wristwatches", "Belts", //1110,1111,1112
            "Alabama", "Michigan", "Texas", //1113,1114,1115
            "Invented the Rubik's Cube", "Invented Superglue", "Invented Surfboards", //1116,1117,1118
            "South African Mobile Telecommunication Company", "Nigerian Mobile Telecommunication Company", "Turkish Mobile Telecommunication Company", //1119,1120,1121
            "Spain", "Italy", "France", //1122,1123,1124
            "Tennis", "Cricket", "Golf", //1125,1126,1127
            "Football", "Boxing", "Basketball", //1128,1129,1130
            "France", "Russia", "Portugal", //1131,1132,1133
            "General Electric", "General Electronics", "General Evolution", //1134,1135,1136
            "Notable Events, Weather and Sports", "Notable Environment, Weather and Sports", "Noticeable Events, Weather and Sports", //1137,1138,1139
            "New York", "Detroit", "California", //1140,1141,1142
            "Belgium", "Germany", "France", //1143,1144,1145
            "co-founder of World Bank", "co-founder of Facebook", "co-founder of Swiss Bank Corporation", //1146,1147,1148
            "co-founder of World Bank", "co-founder of Facebook", "co-founder of Snapchat", //1149,1150,1151
            "Video Game Company", "Transport Company", "Telecommunication Company", //1152,1153,1154
            "American", "British", "Canadian", //1155,1156,1157
            "French Luxury Goods Company", "Italian Luxury Goods Company", "German Luxury Goods Company", //1158,1159,1160
            "French Fashion Company", "Italian Fashion Company", "German Fashion Company", //1161,1162,1163
            "German Luxury Fashion House", "Italian Luxury Fashion House", "French Luxury Fashion House", //1164,1165,1166
            "Playboy Mansion", "Koko Mansion", "Project Fame", //1167,1168,1169
            "co-founder of Facebook", "co-founder of WhatsApp", "co-founder of Snapchat", //1170,1171,1172
            "Comedy", "Football", "Basketball", //1173,1174,1175
            "World's Deepest River", "World's Longest River", "Africa's Longest River", //1176,1177,1178
            "Russia", "Burkina Faso", "Botswana", //1179,1180,1181
            "Linkin Park", "The Beatles", "Aerosmith", //1182,1183,1184
            "Spain", "Argentina", "Colombia", //1185,1186,1187
            "City in India", "City in Uruguay", "City in Singapore", //1188,1189,1190
            "United States of America", "Mexico", "Colombia", //1191,1192,1193
            "City in New Mexico", "City in Mexico", "City in Cuba", //1194,1195,1196
            "A Country in Asia", "A Country in Europe", "A Country in South America", //1197,1198,1199
            "A City in Kenya", "A Country in Africa", "A City in Zimbabwe", //1200,1201,1202
            "United States of America", "Russia", "Germany", //1203,1204,1205
            "England", "Poland", "Canada", //1206,1207,1208
            "Pacific Ocean", "Indian Ocean", "Atlantic Ocean", //1209.1210,1211
            "Sri Lanka", "India", "Iraq", //1212,1213,1214
            "North America", "Europe", "Africa", //1215,1216,1217
            "Point of Sale", "Principle of Sale", "Push of Sale", //1218,1219,1220
            "American Actor", "Footballer", "Singer", //1221,1222,1223
            "United States of America", "Kenya", "South Africa", //1224,1225,1226
            "Illusionist", "Musician", "Basketballer", //1227,1228,1229
            "Boxing", "Tennis", "Golf", //1230,1231,1232
            "Basketball", "Football", "Swimming", //1233,1234,1235
            "Basketball", "Football", "Swimming", //1236,1237,1238
            "The Notorious B.I.G.", "Tupac", "Ice Cube", //1239,1240,1241
            "Chinese", "Japanese", "North Korean", //1242,1243,1244
            "Nigerian", "Ghanian", "South African", //1245,1246,1247
            "Nigerian Novelist", "Ghanian Novelist", "Kenyan Novelist", //1248,1249,1250
            "Burkina Faso", "Kenya", "Angola", //1251,1252,1253
            "Canada", "United States of America", "Australia", //1254,1255,1256
            "United States of America", "Puerto Rico", "Mexico", //1257,1258,1259
            "co-founder of Instagram", "co-founder of Snapchat", "co-founder of Whatsapp", //1260,1261,1262
            "Inventor", "Founder of Tesla Motors", "Designed the Nikon Digital Camera", //1263,1264,1265
            "The Oldest Library in the World", "The Largest Library in the World", "The Smallest Library in the World", //1266,1267,1268
            "Russia", "India", "South Korea", //1269,1270,1271
            "An Island", "A Country", "A City", //1272,1273,1274
            "Irish", "American", "Canadian", //1275,1276,1277
            "Prime Minister of India", "President of India", "Prime Minister of Sri Lanka", //1278,1279,1280
            "China","Japan", "North Korea", //1281,1282,1283
            "President of Turkey", "President of Russia", "President of Germany", //1284,1285,1286
            "co-founder of Spotify", "co-founder of SoundCloud", "co-founder of Shazam", //1287,1288,1289
            "American Football", "Tennis", "Golf", //1290,1291,1292
            "Gymnastics", "Football", "Tennis", //1293,1294,1295
            "Philippines", "India", "Brazil", //1296,1297,1298
            "Gambia", "Ghana", "Zimbabwe", //1299,1300,1301
            "Gambia", "Ghana", "Zimbabwe", //1302,1303,1304
            "Actress", "Musician", "Journalist", //1305,1306,1307
            "Apple", "Samsung", "Microsoft", //1308,1309,1310
            "American Businessman", "Russian Businessman", "German Businessman", //1311,1312,1313
            "C.E.O. of Youtube", "President of Poland", "Prime Minister of Britain", //1314,1315,1316
            "co-founder of Snap inc.", "co-founder of Twitter", "co-founder of Instagram", //1317,1318,1319
            "Chancellor of Germany", "President of Brazil", "Prime Minister of Britain", //1320,1321,1322
            "Supreme Leader of Iran", "Supreme Leader of North Korea", "President of Iraq", //1323,1324,1325
            "C.E.O. of JPMorgan Chase", "C.E.O. of World Bank", "C.E.O. of Goldman Sachs", //1326,1327,1328
            "Prime Minister of Israel", "Prime Minister of Iran", "President of Greece", //1329,1330,1331
            "Disney", "DreamWorks Animation", "Pixar", //1332,1333,1334
            "Chief Executive Officer", "Chosen Executive Officer", "Chief Executive Office", //1335,1336,1337
            "Chief Technology Officer", "Chief Tactical Officer", "Chief Technician Officer", //1338,1339,1340
            "Chief Operative Officer", "Chief Operating Officer", "Chief Operations Officer", //1341,1342,1343
            "Chief Financial Officer", "Chief Finesse Officer", "Chief Financial Official", //1344,1345,1346
            "Chief Instruction Officer", "Chief Information Officer", "Chief Introduction Officer", //1347,1348,1349
            "Country in Asia", "City in Pakistan", "Capital of Afganistan", //1350,1351,1352
            "Massachusetts Institute of Technology", "Massasetts Institute of Technology", "Marvelous Institute of Technology", //1353,1354,1355
            "Africa's First Female President", "Europe's First Female President", "Africa's First Female Pilot", //1356,1357,1358
            "Crime Scene Investigation", "Crime Seen and Investigated", "Checkpoint Scene Investigation", //1359,1360,1361
            "Football", "Tennis", "Basketball", //1362,1363,1364
            "Tennis", "Golf", "Basketball", //1365,1366,1367
            "Golf", "Rugby", "Boxing", //1368,1369,1370
            "Tennis", "Golf", "Basketball", //1371,1372,1373
            "Football", "Tennis", "Basketball", //1374,1375,1376
            "Golf", "Rugby", "Boxing", //1377,1378,1379
            "American Football", "Tennis", "Basketball", //1380,1381,1382
            "Capital of South Africa", "Capital of Sierra Leone", "Capital of Algeria", //1383,1384,1385
            "Football", "Tennis", "Basketball", //1386,1387,1388
            "Football", "Tennis", "Basketball", //1389,1390,1391
            "American", "Mexican", "Canadian", //1392,1393,1394
            "United States of America", "Italy", "France", //1395,1396,1397
            "Italian explorer", "American Explorer", "British Explorer", //1398,1399,1400
            "Animal Farm", "Oliver Twist", "Harry Potter", //1401,1402,1403
            "The Beatles", "Aerosmith", "Coldplay", //1404,1405,1406
            "Greek Philosopher", "American Philosopher", "Italian Philosopher", //1407,1408,1409
            "Spanish Painter", "Italian Painter", "Mexican Painter", //1410,1411,1412
            "Civil Right Activist", "Journalist", "Politician", //1413,1414,1415
            "German Composer", "American Composer", "British Composer", //1416,1417,1418
            "South Africa", "Nigeria", "Ghana", //1419,1420,1421
            "Former Prime Minister of Pakistan", "Former Prime Minister of India", "Former Prime Minister of Iran", //1422,1423,1424
            "Music Artist", "Former President of the United States of America", "Footballer", //1425,1426,1427
            "Egypt", "Rome", "Greece", //1428,1429,1430
            "Austrian neurologist", "American neurologist", "British neurologist", //1431,1432,1433
            "Track and Field Athlete", "Footballer", "Basketballer", //1434,1435,1436
            "of Wales", "of Hanover", "of Northern Ireland", //1437,1438,1439
            "Invented the World Wide Web", "Invented the Telephone", "Invented the Traffic Light Signal", //1440,1441,1442
            "American Cyclist", "American Astronaut", "American Actor", //1443,1444,1445
            "City in Colombia", "City in Argentina", "Capital of Uruguay", //1446,1447,1448
             "Russian Businessman", "Swedish Footballer", "Swedish Businessman", //1449,1450,1451
            "American media mogul", "Australian media mogul", "South African media mogul", //1452,1453,1454
            "English Actor", "Indian Actor", "American Actor", //1455,1456,1457
            "co-founder of Wikipedia", "co-founder of Wikileaks", "co-founder of WeChat", //1458,1459,1460
            "American Author", "British Author", "Canadian Author", //1461,1462,1463
            "Greek Philosopher", "Italian Philosopher", "American Philosopher", //1464,1465,1466
            "Scottish Economist","American Economist", "German Economist", //1467,1468,1469
            "Italian sculptor and painter", "Spanish sculptor and painter", "French sculptor and painter", //1470,1471,1472
            "Greek Philosopher", "Italian Philosopher", "American Philosopher", //1473,1474,1475
            "Ghana", "South Africa", "Angola", //1476,1477,1478
            "South African Surgeon", "American Surgeon", "German Surgeon", //1479,1480,1481
            "Scotland", "United States of America", "France", //1482,1483,1484
            "Russia", "Sweden", "Romania", //1485,1486,1487
            "Chile", "Uganda", "Mali", //1488,1489,1490
            "Australia", "Austria", "Slovakia", //1491,1492,1493
            "Portugal", "Argentina", "India", //1494,1495,1496
            "City in Australia", "City in Austria", "City in England", //1497,1498,1499
            "Africa", "Asia", "Europe", //1500,1501,1502
            "Czech Republic", "Croatia", "Hungary", //1503,1504,1505
            "Asia", "Europe", "North America", //1506,1507,1508
            "New Zealand", "Australia", "Turkey", //1509,1510,1511
            "Asia", "Africa", "South America", //1512,1513,1514
            "North America", "South America", "Europe", //1515,1516,1517
            "Peru", "India", "Chile", //1518,1519,1520
            "Canada", "Australia", "Turkey", //1521,1522,1523
            "Capital of Indonesia", "Capital of Uganda", "Capital of Gambia", //1524,1525,1526
            "Thailand", "Taiwan", "China", //1527,1528,1529
            "Australia", "Austria", "England", //1530,1531,1532
            "Tallest Bridge in the World", "Longest Bridge in the World", "Shortest Bridge in the World", //1533,1534,1535
            "Italy", "Greece", "France", //1536,1537,1538
            "Europe", "Asia", "South America", //1539,1540,1541
            "Turkey", "Greece", "Israel", //1542,1543,1544
            "Australia", "Germany", "France", //1545,1546,1547
            "Greece", "Mexico", "Colombia", //1548,1549,1550
            "Turkmenistan", "Russia", "Morocco", //1551,1552,1553
            "Capital of Malaysia", "Capital of Malawi", "Capital of India", //1554,1555,1556
            "Capital of Austria", "Capital of Australia", "Capital of Italy", //1557,1558,1559
            "City in Mexico", "City in Spain", "City in Argentina", //1560,1561,1562
            "Capital of Romania", "Capital of Morocco", "Capital of Russia", //1563,1564,1565
            "Capital of Azerbaijan", "Located in Ghana", "City in Mali", //1566,1567,1568
            "Capital of Jordan", "Capital of Saudi Arabia", "Capital of Qatar", //1569,1570,1571
            "Répondez s'il vous plait", "Rice and Stew Very Plenty", "Respond if you Can", //1572,1573,1574
            "Pakistan", "Japan", "India", //1575,1576,1577
            "Capital of Bangladesh", "Capital of Senegal", "Capital of Mali", //1578,1579,1580
            "Capital of Senegal", "Capital of Bangladesh", "Capital of Morocco", //1581,1582,1583
            "Capital of Iran", "Capital of Iraq", "Capital of Pakistan", //1584,1585,1586
            "Syria", "Egypt", "Iran", //1587,1588,1589
            "C.E.O. of Hewlett Packard Enterprise", "C.E.O. of Microsoft inc.", "C.E.O. of Dell inc.", //1590,1591,1592
            "Canada", "France", "England", //1593,1594,1595
            "Actor", "Musician", "Footballer", //1596,1597,1598
            "co-founder of Instagram", "co-founder of Facebook", "co-founder of Twitter", //1599,1600,1601
            "co-founder of Instagram", "co-founder of Facebook", "co-founder of Twitter", //1602,1603,1604
            "co-founder of Instagram", "co-founder of Facebook", "co-founder of Twitter", //1605,1606,1607
            "co-founder of WhatsApp Inc.", "co-founder of Apple Inc.", "co-founder of Microsoft Inc.", //1608,1609,1610
            "a.k.a Bruno Mars", "a.k.a French Montana", "a.k.a Jay-Z", //1611,1612,1613
            "Actor", "Footballer", "Basketballer", //1614,1615,1616
            "Italy", "France", "Croatia", //1617,1618,1619
            "Turkey", "Morocco", "Tunisia", //1620,1621,1622
            "Lebanon", "India", "Indonesia", //1623,1624,1625
            "China", "Japan", "South Korea", //1626,1627,1628
            "Singapore", "China", "Japan", //1629,1630,1631
            "United States of America", "Scotland", "Wales", //1632,1633,1634
            "Greece", "Argentina", "Italy", //1635,1636,1637
            "Amazon", "Alibaba Group", "eBay", //1638,1639,1640
            "co-founder of GitHub", "co-founder of Google inc", "co-founder of Whatsapp inc.", //1641,1642,1643
            "co-founder of GitHub", "co-founder of Slack", "co-founder of WeChat", //1644,1645,1646
            "Founder of Dell Technologies", "co-founder of DHL", "co-founder of Twitter", //1647,1648,1649
            "Microsoft Windows", "Linux OS", "Mac OS X", //1650,1651,1652
            "Sweden", "England", "Poland", //1653,1654,1655
            "Cricket", "Football", "Tennis", //1656,1657,1658
            "Golf", "Tennis", "Basketball", //1659,1660,1661
            "Tennis", "Football", "Golf", //1662,1663,1664
            "professional wrestling", "Tennis", "Golf", //1665,1666,1667
            "Cricket", "Football", "Tennis", //1668,1669,1670
            "Singer", "Journalist", "Athlete", //1671,1672,1673
            "a.k.a Katy Perry", "a.k.a Nicki Minaj", "a.k.a Cardi B", //1674,1675,1676
            "American",  "Colombian",  "Mexican", //1677,1678,1679
            "Barbadian", "Mexican", "Colombian", //1680,1681,1682
            "Actor", "Footballer", "Basketballer", //1683,1684,1685
            "British Singer", "American Singer", "Russian Singer", //1686,1687,1688
            "American Actress", "British Actress", "Canadian Actress", //1689,1690,1691
            "American Actor", "British Actor", "French Actor", //1692,1693,1694
            "American", "British", "German", //1695,1696,1697
            "Actor", "Basketballer", "Footballer", //1698,1699,1700
            "Singer",  "Footballer",  "Basketballer", //1701,1702,1703
            "American Actor", "British Actor", "Canadian Actor", //1704,1705,1706
            "Rolling on the Floor Laughing", "Rolling on the Flour Laughing", "Rotating on the Floor Laughing", //1707,1708,1709
            "You Only Live Once", "You Only Leave Once", "You Only Lose One", //1710,1711,1712
            "I know, right", "I know rice", "I kiss right", //1713,1714,1715
            "Black Panther", "Captain America", "Iron Man", //1716, 1717, 1718
            "Actor", "Basketballer", "Footballer", //1719,1720,1721
            "Actress", "Richest Woman in South America", "Richest Woman in Africa", //1722,1723,1724
            "Beninese Singer", "Ghanian Singer", "South African Singer", //1725,1726,1727
            "Mali", "Somalia", "Morocco", //1728,1729,1730
            "South Africa", "Algeria", "Ghana", //1731,1732,1733
            "Nigeria", "Ghana", "South Africa", //1734,1735,1736
            "Ethiopian athlete", "German athlete", "Polish athlete", //1737,1738,1739
            "Ghana", "Cameroon", "Mali", //1740,1741,1742
            "South Sudan",  "North Sudan",  "South Africa", //1743,1744,1745
            "Ethiopian model", "Indian model", "Colombian model", //1746,1747,1748
            "Nigerian Actress", "Ghanian Actress", "South African Actress", //1749,1750,1751
            "Congolese Singer", "Angolan Singer", "Malian Singer", //1752,1753,1754
            "Italy", "France", "Germany", //1755,1756,1757
            "Italy", "France", "Russia", //1758,1759,1760
            "British Dance Instructor", "German Music Composer", "American Tennis Player", //1761,1762,1763
            "American", "British", "Irish", //1764,1765,1766
            "IBM", "Google", "Facebook", //1767,1768,1769
            "co-founder of Oracle Corporation", "co-founder of Google inc.", "co-founder of Facebook", //1770,1771,1772
            "United States of America", "Germany", "France", //1773,1774,1775
            "United States of America", "North Korea", "Italy", //1776,1777,1778
            "Capital of Morocco", "Capital of Argentina", "Capital of Venezuela", //1779,1780,1781
            "City in Mexico", "City in Spain", "City in Colombia", //1782,1783,1784
            "City in Honduras", "City in Spain", "City in Colombia", //1785,1786,1787
            "City in Mexico", "City in India", "City in Spain", //1788,1789,1790
            "City in the Netherlands", "City in South Africa", "City in England", //1791,1792,1793
            "City in Colombia", "City in Mexico", "City in Spain", //1794,1795,1796
            "City in Mexico", "City in Colombia", "City in Cuba", //1797,1798,1799
            "City in Brazil", "City in El Salvador", "City in Mexico", //1800,1801,1802
            "Capital of the Philippines", "Capital of the Netherlands", "Capital of Malaysia", //1803,1804,1805
            "Ghana", "Nigeria", "Algeria", //1806,1807,1808
            "Indonesia", "Kenya", "India", //1809,1810,1811
            "City in Japan", "City in North Korea", "Capital of South Korea", //1812,1813,1814
            "Capital of Cuba", "Capital of Brazil", "Capital of Colombia", //1815,1816,1817
            "Capital of Peru", "Capital of Laos", "Capital of Chile", //1818,1819,1820
            "Capital of Taiwan", "Capital of Japan", "Capital of China", //1821,1822,1823
            "India", "Mexico", "Democratic Republic of the Congo", //1824,1825,1826
            "Capital of Kampala", "Capital of Angola", "Capital of Turkey", //1827,1828,1829
            "City in Israel", "City in France", "City in Romania", //1830,1831,1832
            "United States of America", "Canada", "United Kingdom", //1833,1834,1835
            "United States of America", "Russia", "Hungary", //1836,1837,1838
            "Argentina", "United States of America",  "Canada", //1839,1840,1841
            "Capital of China", "Capital of Ecuador", "Capital of Qatar", //1842,1843,1844
            "Ukraine", "Poland", "Sweden", //1845,1846,1847
            "United States of America", "Colombia", "Spain", //1848,1849,1850
            "Africa", "South America", "Asia", //1851,1852,1853
            "South Africa", "United Kingdom", "Scotland", //1854,1855,1856
            "Kenya", "Ghana", "Somalia", //1857,1858,1859
            "Saudi Arabia", "Tanzania", "Iraq", //1860,1861,1862
            "Capital of Ethiopia", "Capital of Senegal", "Capital of Sierra Leone", //1863,1864,1865
            "Capital of Mozambique",  "Capital of Angola",  "Capital of Kenya", //1866,1867,1868
            "Capital of Mali", "Capital of Gambia", "Capital of Rwanda", //1869,1870,1871
            "Morocco", "Mexico", "Colombia", //1872,1873,1874
            "City in Kenya", "Capital of Burkina Faso", "City in Tanzania", //1875,1876,1877
            "Capital of Kenya",  "Capital of Gabon",  "Capital of Somalia", //1878,1879,1880
            "The Largest City in Africa", "The Largest City in West Africa", "The Largest City in East Africa", //1881,1882,1883
            "Capital of the Republic of the Congo", "Capital of the Democratic Republic of the Congo", "Capital of Côte d’Ivoire", //1884,1885,1886
            "Ghana", "Angola", "Kenya", //1887,1888,1889
            "Japan", "China", "North Korea", //1890,1891,1892
            "Norway", "United States of America", "Scotland", //1893,1894,1895
            "Film Director", "Football Coach", "Song Writer", //1896,1897,1898
            "Football", "Cricket", "Basketball", //1899,1900,1901
            "Colombia", "Argentina", "Bolivia", //1902,1903,1904
            "Venezuela", "Argentina", "Colombia", //1905,1906,1907
            "Argentine", "Mexican", "Colombian", //1908,1909,1910
            "Baseball", "Cricket", "Swimming", //1911,1912,1913
            "Italian Astronomer", "French Astronomer", "American Astronomer", //1914,1915,1916
            "Irish singer", "German singer", "French singer", //1917,1918,1919
            "Musician", "Footballer", "Basketballer", //1920,1921,1922
            "South Korean Singer", "North Korean Singer", "Japanese Singer", //1923,1924,1925
            "Actor", "Footballer", "Basketballer", //1926,1927,1928
            "Musician", "Sorcerer", "Astronomer", //1929,1930,1931
            "Founder of KFC", "Founder of Harley Davidson Motorcycles", "Founder of Pizza Hut", //1932,1933,1934
            "American", "British", "Irish", //1935,1936,1937
            "Actor", "Footballer", "Basketballer", //1938,1939,1940
            "Actor", "Footballer", "Basketballer", //1941,1942,1943
            "Nigeria", "South Africa", "Ghana", //1944,1945,1946
            "Comedy", "Sorcery", "Astronomy", //1947,1948,1949
            "United Kingdom", "United States of America", "United Arab Emirates", //1950,1951,1952
            "Athlete", "Singer", "Journalist", //1953,1954,1955
            "Canadian", "American", "British", //1956,1957,1958
            "Actress", "Athlete", "Journalist", //1959,1960,1961
            "Singer", "American Politician", "Prime Minister of the United Kingdom", //1962,1963,1964
            "American Actress", "Spanish Actress", "Colombian Actress", //1965,1966,1967
            "American Actress", "co-founder of Fox News", "American Politician", //1968,1969,1970
            "The Black Eyed Peas", "Linkin Park", "Coldplay", //1971,1972,1973
            "Actress", "Journalist", "Athlete", //1974,1975,1976
            "Actress", "Journalist", "Athlete", //1977,1978,1979
            "Actress", "American Politician", "Prime Minister of the United Kingdom", //1980,1981,1982
            "Singer", "Footballer", "Journalist", //1983,1984,1985
            "Actress", "Singer", "Journalist", //1986,1987,1988
            "D'banj", "Wizkid", "Davido", //1989,1990,1991
            "David Adedeji Adeleke", "Oladapo Daniel Oyebanjo", "Ayodeji Ibrahim Balogun", //1992,1993,1994
            "Jamie Foxx", "Brad Pitt", "Ludacris", //1995,1996,1997
            "Notorious B.I.G", "Ludacris", "50 Cent", //1998,1999,2000
            "T-Pain", "50 Cent", "Jay-Z", //2001,2002,2003
            "Public Relations", "Production Rules", "Public Rehabitation",  //2004,2005,2006
            "Alicia Keys", "Cardi B", "Nicki Minaj", //2007,2008,2009
            "The Weeknd", "Bruno Mars", "Eminem", //2010,2011,2012
            "Bruno Mars", "Snoop Dogg", "P Diddy", //2013,2014,2015
            "Angola", "Brazil", "Spain", //2016,2017,2018
            "South African comedian", "American comedian", "Russian comedian", //2019,2020,2021
            "Football", "Basketball", "Boxing", //2022,2023,2024
            "Football", "Golf", "Tennis", //2025,2026,2027
            "Kenya", "Egypt", "Britain", //2028,2029,2030
            "Swimming", "Football", "Tennis", //2031,2032,2033
            "Nigeria", "Egypt", "Morocco", //2034,2035,2036
            "Egypt", "Iraq", "Pakistan", //2037,2038,2039
            "Nigeria", "Ghana", "Egypt", //2040,2041,2042
            "Kenya", "Egypt", "Mali", //2043,2044,2045
            "Capital of Angola", "Capital of Rwanda", "Capital of Algeria", //2046,2047,2048
            "City in Algeria", "City in Mexico", "City in Morocco", //2049,2050,2051
            "Libya", "Brazil", "France", //2052,2053,2054
            "Capital of Tunisia", "City in Italy", "City in Turkey", //2055,2056,2057
            "Absent Without Leave", "Absent With Leave", "Away Without License", //2058,2059,2060
            "Missing In Action", "Massachusetts Institute of Accounting", "Mobilization of International Antiquities", //2061,2062,2063
            "Special Weapons And Tactics", "Swift Weapons And Tactics", "Spectacular Weapons And Tactics", //2064,2065,2066
            "Delivered On Air", "Dead On Arrival", "Done On Agreement", //2067,2068,2069
            "Estimated Time of Arrival", "Exact Time of Arrival", "Elongated Time of Arrival", //2070,2071,2072
            "Unlicensed Flying Object", "Unidentified Flying Object", "Unregistered Flying Object", //2073,2074,2075
            "For Your Information", "For Your Interest", "For Your Investigation", //2076,2077,2078
            "Social Security Number", "Secret Security Number", "Social Secret Number", //2079,2080,2081
            "Greenwich Meridian Time", "Get Main Time", "Greenwich Mean Time", //2082,2083,2084
            "Human Resources", "Humane Risks", "Humane Resources", //2085,2086,2087
            "Curriculum Vitae", "Curriculum Vital", "Curriculum Voucher", //2088,2089,2090
            "A Country", "A Continent", "A City", //2091,2092,2093
            "City in China", "City in Japan", "City in North Korea", //2094,2095,2096
            "Africa", "Europe", "South America" //2097,2098,2099















    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-9884126874121857/8463984325");
            mInterstitialAd.loadAd(new AdRequest.Builder()
                    //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    //.addTestDevice("7F3FC1BDD7BB75005B7F823B325F2A08")
                    .build());




            /*if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
            } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
            }*/
          //  MobileAds.initialize(this, "ca-app-pub-9884126874121857~6016182321");



            /*Display display = getWindowManager().getDefaultDisplay();
            Point screenSize = new Point();
            display.getRealSize(screenSize);
            int size = Math.min(screenSize.x, screenSize.y);
            int buttonSize = Math.round(size * 0.1f);
     ImageButton button_play = (ImageButton) findViewById(R.id.myButton);
     button_play.setMaxWidth(buttonSize);
     button_play.setMaxHeight(buttonSize);*/










             AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater layerInflater = MainActivity.this.getLayoutInflater();
        View view = layerInflater.inflate(R.layout.replay, null);
        builder.setView(view);
        dialog = builder.create();
        dialog.setOwnerActivity(MainActivity.this);
        dialog.setCancelable(false);  //Where the Number 3 of bugQAEDA was found and destroyed





        Log.e(TAG, "running onCreate()");


        pb = (ProgressBar) findViewById(R.id.progressbar);
        tv = (TextView) findViewById(R.id.tvque);
        points = (TextView) findViewById(R.id.scoreview);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        change = (ToggleButton) findViewById(R.id.toggleButton);
        r = (RelativeLayout) findViewById(R.id.rL);
        //Context context = getApplicationContext();
        //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
        //soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
        //sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        //soundId = sp.load(context, R.raw.buttonsound, 1);
        //soundId2 = sp.load(context, R.raw.wronganswer, 1);



        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        r.setBackgroundColor(randomAndroidColor);




        LoadSoundState();
        // SaveSoundState();
        loadSavedPreferences();
        highest = Integer.parseInt(savedscore);




        i = new pbClass();
        //i.execute();



        Generation(); //Randomize Questions
        Gen(); //Generates a random integer value between 0 and Questions.size()
        Genn();// Randomize the order of options to a particular question
        tv.setText(Questions[flag]);
        btn0.setText(Options[(flag * 3) + a]);
        btn1.setText(Options[(flag * 3) + b]);
        btn2.setText(Options[(flag * 3) + c]);

        btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        i.cancel(true);

                        btn0.setEnabled(false);
                        btn1.setEnabled(false);
                        btn2.setEnabled(false);




                        stopPlayingR();
                        stopPlayingW();
                        stopPlayingH();

                        soundC = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                        soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                        soundH = MediaPlayer.create(MainActivity.this, R.raw.highscore);

                        Button urAns = (Button) findViewById(btn0.getId());
                        ansText = urAns.getText().toString();

                        if (ansText.equalsIgnoreCase(Answers[flag])) {
                                correct++;
                                // if(v == btn0) {
                                btn0.setBackgroundResource(R.drawable.green);
                                // }
                                final Handler handler = new Handler() {  //where the Number 2 of bugQAEDA was found and destroyed
                                };
                                points.setText(String.valueOf(correct));
                                if (change.isChecked()) {

                                   if(correct > 0 && correct == highest) {
                                    soundH.start();
                                    soundC.setVolume(0, 0);
                                   }


                                       //stopPlayingR();
                                       //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                       soundC.start();
                                       //sp.play(soundId, 1, 1, 0, 0, 1);


                                } else {
                                        //stopPlayingR();
                                        //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                        soundC.setVolume(0, 0);
                                       //sp.pause(soundId);
                                }

                                Gen();
                                Genn();
                                handler.postDelayed(new Runnable() {
                                        public void run() {

                                                btn0.setBackgroundResource(R.drawable.custom_button);
                                                if (flag < Questions.length) {

                                                        i = new pbClass();
                                                        i.execute();
                                                        btn0.setEnabled(true);
                                                        btn1.setEnabled(true);
                                                        btn2.setEnabled(true);
                                                        tv.setText(Questions[flag]);
                                                        btn0.setText(Options[(flag * 3) + a]);
                                                        btn1.setText(Options[(flag * 3) + b]);
                                                        btn2.setText(Options[(flag * 3) + c]);
                                                } else {

                                                        //still coming back to this
                                                        Log.e(TAG, "problem!!");

                                                }


                                        }
                                }, 150);


                        } else {

                               // mInterstitialAd.show();
                                //if(v == btn0) {
                                if (change.isChecked()) {

                                 //stopPlayingW();
                                 //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                 soundW.start();
                                        //sp.play(soundId2, 1, 1, 0, 0, 1);
                                } else {
                                     //stopPlayingW();
                                     //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                     soundW.setVolume(0, 0);
                                        //sp.pause(soundId2);
                                }


                                btn0.setBackgroundResource(R.drawable.red);


                         final Handler handler2 = new Handler() {
                         };

                         handler2.postDelayed(new Runnable() {
                          public void run() {
                           if(btn1.getText().equals(Answers[flag])){
                            btn1.setBackgroundResource(R.drawable.green);
                           }else if(btn2.getText().equals(Answers[flag])){
                            btn2.setBackgroundResource(R.drawable.green);
                           }

                          }
                         }, 1000);








                                // }

                                final Handler handler = new Handler() {
                                };
                                handler.postDelayed(new Runnable() {
                                        public void run() {
                                                btn0.setBackgroundResource(R.drawable.custom_button);


//


                                                points.setText(String.valueOf(correct));


                                                i.onPostExecute("s");

                                        }
                                }, 2500);




                        }
                        //rg.clearCheck();
                        //flag++;

                        //checks if the current value of flag is less than the number of questions in the array

                }
        }); // btn0 close



            btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            i.cancel(true);

                            btn0.setEnabled(false);
                            btn1.setEnabled(false);
                            btn2.setEnabled(false);




                            stopPlayingR();
                            stopPlayingW();
                            stopPlayingH();
                            soundC = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                            soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                            soundH = MediaPlayer.create(MainActivity.this, R.raw.highscore);

                            Button urAns = (Button) findViewById(btn1.getId());
                            ansText = urAns.getText().toString();

                            if (ansText.equalsIgnoreCase(Answers[flag])) {
                                    correct++;
                                    // if(v == btn1) {
                                    btn1.setBackgroundResource(R.drawable.green);
                                    // }
                                    final Handler handler = new Handler() {
                                    };
                                    points.setText(String.valueOf(correct));
                                    if (change.isChecked()) {

                                     if(correct > 0 && correct == highest) {
                                      soundH.start();
                                      soundC.setVolume(0, 0);
                                     }


                                     //stopPlayingR();
                                      // mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                       soundC.start();
                                            //sp.play(soundId, 1, 1, 0, 0, 1);
                                    } else {
                                        //stopPlayingR();
                                        //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                        soundC.setVolume(0, 0);
                                            //sp.pause(soundId);
                                    }

                                    Gen();
                                    Genn();
                                    handler.postDelayed(new Runnable() {
                                            public void run() {

                                                    btn1.setBackgroundResource(R.drawable.custom_button);
                                                    if (flag < Questions.length) {

                                                            i = new pbClass();
                                                            i.execute();
                                                            btn0.setEnabled(true);
                                                            btn1.setEnabled(true);
                                                            btn2.setEnabled(true);
                                                            tv.setText(Questions[flag]);
                                                            btn0.setText(Options[(flag * 3) + a]);
                                                            btn1.setText(Options[(flag * 3) + b]);
                                                            btn2.setText(Options[(flag * 3) + c]);
                                                    } else {

                                                            //still coming back to this
                                                            Log.e(TAG, "problem!!");

                                                    }


                                            }
                                    }, 150);


                            } else {
                                   // mInterstitialAd.show();
                                    // if(v == btn1) {
                                    if (change.isChecked()) {

                                       //stopPlayingW();
                                       //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                       soundW.start();
                                            //sp.play(soundId2, 1, 1, 0, 0, 1);
                                    } else {
                                         //stopPlayingW();
                                         //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                         soundW.setVolume(0, 0);
                                            //sp.pause(soundId2);
                                    }


                                    btn1.setBackgroundResource(R.drawable.red);

                             final Handler handler2 = new Handler() {
                             };

                             handler2.postDelayed(new Runnable() {
                              public void run() {
                               if(btn0.getText().equals(Answers[flag])){
                                btn0.setBackgroundResource(R.drawable.green);
                               }else if(btn2.getText().equals(Answers[flag])){
                                btn2.setBackgroundResource(R.drawable.green);
                               }

                              }
                             }, 1000);






                                    // }

                                    final Handler handler = new Handler() {
                                    };
                                    handler.postDelayed(new Runnable() {
                                            public void run() {
                                                    btn1.setBackgroundResource(R.drawable.custom_button);


//


                                                    points.setText(String.valueOf(correct));

                                                    i.onPostExecute("s");

                                            }
                                    }, 2500);


                            }
                            //rg.clearCheck();
                            //flag++;

                            //checks if the current value of flag is less than the number of questions in the array

                    }
            }); // btn1 close



            btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            i.cancel(true);

                            btn0.setEnabled(false);
                            btn1.setEnabled(false);
                            btn2.setEnabled(false);




                           stopPlayingR();
                           stopPlayingW();
                           stopPlayingH();
                           soundC = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                           soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                           soundH = MediaPlayer.create(MainActivity.this, R.raw.highscore);

                            Button urAns = (Button) findViewById(btn2.getId());
                            ansText = urAns.getText().toString();

                            if (ansText.equalsIgnoreCase(Answers[flag])) {
                                    correct++;
                                    //if(v == btn2) {
                                    btn2.setBackgroundResource(R.drawable.green);
                                    //}
                                    final Handler handler = new Handler() {
                                    };
                                    points.setText(String.valueOf(correct));
                                    if (change.isChecked()) {

                                     if(correct > 0 && correct == highest) {
                                      soundH.start();
                                      soundC.setVolume(0, 0);
                                     }


                                     //stopPlayingR();
                                       //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                       soundC.start();;
                                            //sp.play(soundId, 1, 1, 0, 0, 1);
                                    } else {
                                       //stopPlayingR();
                                        //mp = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                                        soundC.setVolume(0, 0);
                                            //sp.pause(soundId);
                                    }

                                    Gen();
                                    Genn();
                                    handler.postDelayed(new Runnable() {
                                            public void run() {

                                                    btn2.setBackgroundResource(R.drawable.custom_button);


                                                    if (flag < Questions.length) {

                                                            i = new pbClass();
                                                            i.execute();
                                                            btn0.setEnabled(true);
                                                            btn1.setEnabled(true);
                                                            btn2.setEnabled(true);
                                                            tv.setText(Questions[flag]);
                                                            btn0.setText(Options[(flag * 3) + a]);
                                                            btn1.setText(Options[(flag * 3) + b]);
                                                            btn2.setText(Options[(flag * 3) + c]);
                                                    } else {

                                                            //still coming back to this
                                                            Log.e(TAG, "problem!!");

                                                    }

                                            }
                                    }, 150);


                            } else {

                                  //  mInterstitialAd.show();
                                    // if(v == btn2) {
                                    if (change.isChecked()) {

                                       //stopPlayingW();
                                       //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                       soundW.start();;
                                            //sp.play(soundId2, 1, 1, 0, 0, 1);
                                    } else {
                                         //stopPlayingW();
                                         //mp = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                                         soundW.setVolume(0, 0);
                                            //sp.pause(soundId2);
                                    }


                                    btn2.setBackgroundResource(R.drawable.red);

                             final Handler handler2 = new Handler() {
                             };

                             handler2.postDelayed(new Runnable() {
                              public void run() {
                               if(btn0.getText().equals(Answers[flag])){
                                btn0.setBackgroundResource(R.drawable.green);
                               }else if(btn1.getText().equals(Answers[flag])){
                                btn1.setBackgroundResource(R.drawable.green);
                               }

                              }
                             }, 1000);







                                    // }

                                    final Handler handler = new Handler() {
                                    };
                                    handler.postDelayed(new Runnable() {
                                            public void run() {
                                                    btn2.setBackgroundResource(R.drawable.custom_button);


//


                                                    points.setText(String.valueOf(correct));

                                                    i.onPostExecute("s");

                                            }
                                    }, 2500);


                            }
                            //rg.clearCheck();
                            //flag++;

                            //checks if the current value of flag is less than the number of questions in the array

                    }
            }); // btn2 close


            /*change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(change.isChecked() == false){
                        if(soundW.isPlaying())
                            soundW.setVolume(0, 0);
                    }else{
                        soundW.setVolume(1, 1);
                    }
                   *//* if(change.isChecked() == true){
                        soundW.setVolume(1, 1);
                    }*//*


                }
            });*/

            /*mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                           if(AdCheck == 0){
                                   mInterstitialAd.show();
                           }

                            // Code to be executed when an ad finishes loading.
                            Log.i("Ads", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                            // Code to be executed when an ad request fails.
                            Log.i("Ads", "onAdFailedToLoad");
                    }

                    @Override
                    public void onAdOpened() {

                            // Code to be executed when the ad is displayed.
                            Log.i("Ads", "onAdOpened");
                    }

                    @Override
                    public void onAdLeftApplication() {
                            // Code to be executed when the user has left the app.
                            Log.i("Ads", "onAdLeftApplication");
                    }

                    @Override
                    public void onAdClosed() {
                            // Code to be executed when when the interstitial ad is closed.
                            Log.i("Ads", "onAdClosed");
                    }
            });*/








/*
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.cancel(true);

                RadioButton urAns = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String ansText = urAns.getText().toString();

                if (ansText.equalsIgnoreCase(Answers[flag])) {
                    correct++;
                    points.setText(String.valueOf(correct));

                } else {
                    points.setText(String.valueOf(correct));
                    i.onPostExecute("s");












                } ///closes the else statement above
                rg.clearCheck();
                flag++;

                    //checks if the current value of flag is less than the number of questions in the array
                if (flag < Questions.length) {

                    i = new pbClass();
                    i.execute();
                    tv.setText(Questions[flag]);
                    rb0.setText(Options[flag * 3]);
                    rb1.setText(Options[(flag * 3) + 1]);
                    rb2.setText(Options[(flag * 3) + 2]);
                } else {
                    //still coming back to this
                }


            }
        });*/

    }





   /* @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){


        }else{}

    }*/

    class pbClass extends AsyncTask<String, Integer, String> { //i think the issue with the dialogbox popping twice is hidden somewhere in this annoying class

        @Override
        protected void onPreExecute() {



            super.onPreExecute();


        }

        @Override
        protected String doInBackground(String... params) {
            for (int i = 100; i >= 0; i--) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                   // e.printStackTrace();
                }




                if (isCancelled())
                    break;
                publishProgress(i);



            }
            Log.e(TAG, "Something is going wrong here");
           /* if(!isCancelled()) {
                soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
                soundW.start();
            }*/


            return "finish";

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

         if(isCancelled() == false){
           if (change.isChecked()) {
            stopPlayingW();
            soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
            soundW.start();
            //sp.play(soundId2, 1, 1, 0, 0, 1);
           }else{
             stopPlayingW();
             soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
             soundW.setVolume(0, 0);
           }
         }

               //getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            //mInterstitialAd.show(); //change position of this
            if (correct >= highest) {
                highest = correct;
                   // bestS.setTextColor(getResources().getColor(R.color.text));
                String BestScore = String.valueOf(highest);
                savedPreferences("improve", BestScore);
                SaveSoundState();
            }









/*
            builder.setButton(AlertDialog.BUTTON_POSITIVE, "Replay", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Intent it = new Intent("com.example.deji.knowthename.MainActivity");
                    startActivity(it);
                }
            });

            builder.setButton(AlertDialog.BUTTON_NEGATIVE, "MainMenu", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Intent r = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(r);
                }
            });*/

            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    MainActivity.this.finish();
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                }
            });


            //dialog.show();
           /* had to use this here to catch the error caused by the double popping of the alert dialogbox
            you can try this without d try n catch and see wot happens */
            try {
                Log.e(TAG, "what is happening here");
                dialog.show();
                    mInterstitialAd.show();


                Log.e(TAG, "hello");

            } catch (Exception e) {
            }

            tv.setVisibility(View.GONE);
            btn0.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            //rg.setVisibility(View.GONE);
            // btNext.setVisibility(View.GONE);
            pb.setVisibility(View.GONE);
                points.setVisibility(View.GONE);
                change.setVisibility(View.GONE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


            newS = (TextView) dialog.findViewById(R.id.tv3);
            bestS = (TextView) dialog.findViewById(R.id.tv4);
            replay = (Button) dialog.findViewById(R.id.btnL);
            MainMenu = (Button) dialog.findViewById(R.id.btnR);

                if(correct > 0 && correct >= highest){
                        newS.setTextColor(getResources().getColor(R.color.text));
                        bestS.setTextColor(getResources().getColor(R.color.text));
                }

                newS.setText(String.valueOf(correct));
                bestS.setText("Best : " + String.valueOf(highest));



                replay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                            SaveSoundState();
                            //sp.stop(soundId2);

                       if(soundW.isPlaying())
                          soundW.stop();

                            MainMenu.setEnabled(false);



                    /*if (change.isChecked()) {
                        // sound = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                        soundC.start();
                    } else {
                        soundC.setVolume(0, 0);
                    }*/
                            finish();
                            Intent it = new Intent("com.dejman.deji.knowthename.MainActivity");
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            startActivity(it);


                    }
            });


            MainMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                     if(soundW.isPlaying())
                      soundW.stop();
                            replay.setEnabled(false);
                            //sp.pause(soundId2);
                   /* if (change.isChecked()) {
                        //sound = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
                        soundC.start();
                    } else {
                        soundC.setVolume(0, 0);
                    }*/

                            finish();

                            Intent m = new Intent(getApplicationContext(), MenuActivity.class);
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                            startActivity(m);


                    }
            });


        }
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        savedscore = sharedPreferences.getString("improve", "0");
    }

    private void savedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SaveSoundState();

       /* SharedPreferences SoundState = getSharedPreferences("MYPREFS", 0);
        SharedPreferences.Editor editor = SoundState.edit();
        editor.putBoolean("cstate", change.isChecked());
        editor.commit();*/
    }



    private void SaveSoundState() {
        SharedPreferences SoundState = getSharedPreferences("MYPREFS", 0);
        SharedPreferences.Editor editor = SoundState.edit();
        editor.putBoolean("cstate", change.isChecked());
        editor.commit();

    }

        private void LoadSoundState() {

                SharedPreferences SoundState = getSharedPreferences("MYPREFS", 0);
                change.setChecked((SoundState.getBoolean("cstate", change.isChecked())));
       /* SharedPreferences SoundState = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        change.setChecked(SoundState.getBoolean("cstate", false));  /*/

        }

    private void Generation() {


        for (k = 0; k < Questions.length; k++) {
            list.add(k);
        }

        Collections.shuffle(list);

    }
    private int Gen() {
        int value;
        int j = 0;

        value = list.remove(j);
        flag = value;


        j++;

        return flag;


    }

    private void Genn(){

        for(int l = 0; l < 3; l++){
            options.add(l);
        }
        Collections.shuffle(options);

        a = options.remove(0);
        b = options.remove(0);
        c = options.remove(0);

        int g = options.size();
        String f = String.valueOf(g);
        Log.e(TAG, f);
    }

    public void onBackPressed(){
            i.cancel(true); //Where the Nuumber 1 leader of bugQAEDA was found and destroyed
            stopPlayingW();
            stopPlayingR();
            stopPlayingH();
            soundW = MediaPlayer.create(MainActivity.this, R.raw.wronganswer);
            soundC = MediaPlayer.create(MainActivity.this, R.raw.buttonsound);
            if(soundW.isPlaying())
               soundW.stop();

        super.onBackPressed();

        Intent r = new Intent(MainActivity.this, MenuActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(r);

    }

     private void stopPlayingR() {
      if (soundC != null) {
       soundC.stop();
       soundC.release();
       soundC = null;
      }

     }

     private void stopPlayingW() {
      if (soundW != null) {
       soundW.stop();
       soundW.release();
       soundW = null;
      }

     }

     private void stopPlayingH() {
      if (soundH != null) {
       soundH.stop();
       soundH.release();
       soundH = null;
      }

     }





}

























